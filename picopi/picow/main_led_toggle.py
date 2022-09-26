import usocket as socket
import network
from machine import Pin
import secrets

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

def connexion_wifi(ssid,password):
    wlan = network.WLAN(network.STA_IF)
    wlan.active(True)
    if not wlan.isconnected():
        print("connexion",ssid)
        wlan.connect(secrets.SSID, secrets.PASSWORD)
        while not wlan.isconnected():
            pass
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

while True :
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
                Led = "ON"
            elif url[7:] == 'off':
                light.off()
                Led = "OFF"
            elif url[7:] == 'toggle':
                light.toggle()
        ClientSocket.send(htmlresponse.format(Led))
    ClientSocket.close()