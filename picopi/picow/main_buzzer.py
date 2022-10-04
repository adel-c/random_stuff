from machine import Pin, PWM
import time
from time import sleep
""" led = Pin(0,Pin.OUT)
sensor =Pin(2,Pin.IN)
led.value(1)
while True:
   
    print(sensor.value())
    if sensor.value()==1:
        led.value(0)
    else:
        led.value(1) """
#led = Pin(2,Pin.OUT)
BuzzerObj=PWM(Pin(2))
#led.value(100)
def buzzer(buzzerPinObject,frequency,sound_duration,silence_duration):

    buzzerPinObject.duty_u16(int(65536*0.2))
    buzzerPinObject.freq(frequency)
    sleep(sound_duration)
    buzzerPinObject.duty_u16(int(65536*0))
    sleep(silence_duration)
while True:
    #nec.transmit(0,12)
    buzzer(BuzzerObj,523,0.5,0.1)
 #C (DO)

    buzzer(BuzzerObj,587,0.5,0.1)
 #D (RE)

    buzzer(BuzzerObj,659,0.5,0.1) #E (MI)
    buzzer(BuzzerObj,698,0.5,0.1) #F (FA)

    buzzer(BuzzerObj,784,0.5,0.1) #G (SOL)
    buzzer(BuzzerObj,880,0.5,0.1) #A (LA)
    buzzer(BuzzerObj,987,0.5,0.1) #B (SI)
    time.sleep_ms(30)
