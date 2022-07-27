from machine import Pin, I2C
import utime as time
from dht import DHT11, InvalidChecksum,InvalidPulseCount

while True:
    print("start")
    pin = Pin(28, Pin.IN, Pin.PULL_UP)
    sensor = DHT11(pin)
    time.sleep(5)
    try:
       
        t  = (sensor.temperature)
        h = (sensor.humidity)
        print("Temperature: {}".format(t))
        print("Humidity: {}".format(h))
    except InvalidPulseCount:    
        print ("exception")

