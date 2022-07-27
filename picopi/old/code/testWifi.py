from machine import UART, Pin
import time
from esp8266 import ESP8266
from dht import DHT11, InvalidChecksum,InvalidPulseCount
esp01 = ESP8266()

esp8266_at_ver = None

led=Pin(25,Pin.OUT)

print("StartUP",esp01.startUP())

#print("ReStart",esp01.reStart())

print("StartUP",esp01.startUP())

print("Echo-Off",esp01.echoING())

print("\r\n\r\n")

'''

Print ESP8266 AT command version and SDK details

'''

esp8266_at_var = esp01.getVersion()

if(esp8266_at_var != None):

    print(esp8266_at_var)

'''

set the current WiFi in SoftAP+STA

'''


setwifi = esp01.setCurrentWiFiMode(1)
time.sleep(2)
currentWifi= esp01.getCurrentWiFiMode()
time.sleep(2)
print("current wifi mode {} set wifi {}".format(currentWifi,setwifi))
#apList = esp01.getAvailableAPs()

#for items in apList:
#    print(items)
#    for item in tuple(items):
#        print(item)

print("\r\n\r\n")

'''

Connect with the WiFi

'''

print("Try to connect with the WiFi..")

while (1):
    #break;
    connectionResult= esp01.connectWiFi("Astera","aceace33")
    print(connectionResult)
    if "WIFI CONNECTED" in connectionResult:

        print("ESP8266 connect with the WiFi..")

        break;

    else:
        
        print(".")

        time.sleep(2)

print("\r\n\r\n")

print("Now it's time to start HTTP Get/Post Operation.......\r\n")

while(1):   

    led.toggle()
    pin = Pin(28, Pin.IN, Pin.PULL_UP)
    sensor = DHT11(pin)
    time.sleep(20)

   

    try:
       
        t  = (sensor.temperature)
        h = (sensor.humidity)
        print("Temperature: {}".format(t))
        print("Humidity: {}".format(h))
        post_json='Temperature:'+str(t)+', Humidity:'+str(h)+''  #"{\"name\":\"Noyel\"}"
        httpCode, httpRes = esp01.doHttpPost("192.168.1.227","/","text",post_json,8888, "")
    except InvalidPulseCount:    
        print ("exception")
    #httpCode, httpRes = esp01.doHttpPost("www.httpbin.org","/post","RPi-Pico",post_json,80, "application/json",)
    


    print("--------------------------------------------------------------------------------\r\n\r\n")

    #break

