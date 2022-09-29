import usocket as socket
import network
from machine import Pin
import secrets
import time
from umqtt.simple import MQTTClient

wlan = network.WLAN(network.STA_IF)
wlan.active(True)
wlan.connect(secrets.SSID, secrets.PASSWORD)
light = machine.Pin("LED", machine.Pin.OUT)

Led = "ON"

htmlresponse = """HTTP/1.0 200 OK
Content-Type: text/html

<!DOCTYPE html>
<meta charset="UTF-8">
<html>
    <head>
        <title>Serveur RaspiPicoW</title>
    </head>
    <body>
        <p>Etat de la LED : {} </p>
        <p> <a href = "/?etat=on" >Led ON </a>  </p>
        <p> <a href = "/?etat=off" >Led OFF </a> </p>
        <p> <a href = "/?etat=toggle" >TOGGLE </a> </p>
    </body>
</html>
"""


mqtt_server = '192.168.1.227'
#mqtt_server = 'broker.hivemq.com'
client_id = 'bigles'
topic_pub = b'topi1'
topic_sub = b'topi1'
topic_msg = b'Movement Detected'

def sub_cb(topic, msg):
    print("New message on topic {}".format(topic.decode('utf-8')))
    msg = msg.decode('utf-8')
    print(msg)
    if msg == "on":
        light.on()
    elif msg == "off":
        light.off()
        
def mqtt_connect():
    print('Connecting to %s MQTT Broker'%(mqtt_server))
    client = MQTTClient(client_id, mqtt_server, keepalive=3600)
    client.set_callback(sub_cb)
    client.connect()
    print('Connected to %s MQTT Broker'%(mqtt_server))
    return client
def reconnect():
    print('Failed to connect to the MQTT Broker. Reconnecting...')
    time.sleep(5)
    machine.reset()



def connexion_wifi(ssid,password):
    wlan = network.WLAN(network.STA_IF)
    wlan.active(True)
    while not wlan.isconnected():
        print("connexion",ssid)
        wlan.connect(secrets.SSID, secrets.PASSWORD)
        time.sleep(5)
        print("Connection status :", wlan.isconnected())
        
    print("Adresse IP :", wlan.ifconfig()[0])
    print("Masque reseau : ", wlan.ifconfig()[1])
    print("Gateway :", wlan.ifconfig()[2])
    print("Serveur DNS :", wlan.ifconfig()[3])
    return wlan.ifconfig()[0]

AdresseIP = connexion_wifi(secrets.SSID, secrets.PASSWORD)
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
s.bind((AdresseIP,8080))
s.listen(1)

try:
    client = mqtt_connect()
except OSError as e:
    reconnect()

def handle(topic,msg):
    print( 'topic ',topic)
    print('msg ', msg)




while True :
    client.subscribe(topic_sub)
    print("Attente connexion ...")
    connexion = s.accept()
    ClientAddress = connexion[1]
    ClientSocket = connexion[0]
    print("Adresse client connecté :",ClientAddress[0])
    request = ClientSocket.recv(2048)
    Lrequest = request.decode('utf-8').split(' ')
    if Lrequest[0] == 'GET' :
        url =Lrequest[1]
        if url[0:7] =="/?etat=":
            if url[7:] == 'on':
                light.on()
                client.publish(topic_pub, topic_msg)
                Led = "ON"
            elif url[7:] == 'off':
                light.off()
                Led = "OFF"
            elif url[7:] == 'toggle':
                light.toggle()
        ClientSocket.send(htmlresponse.format(Led))
    ClientSocket.close()