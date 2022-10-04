from machine import Pin
import time

""" led = Pin(0,Pin.OUT)
sensor =Pin(2,Pin.IN)
led.value(1)
while True:
   
    print(sensor.value())
    if sensor.value()==1:
        led.value(0)
    else:
        led.value(1) """
from ir_rx.philips import RC6_M0  # NEC remote, 8 bit addresses

from ir_tx.philips import RC6_M0 as RC6T
nec = RC6T(Pin(0, Pin.OUT, value = 0))
  # address == 1, data == 2
def callback(data, addr, ctrl):
    if data < 0:  # NEC protocol sends repeat codes.
        print('Repeat code.')
    else:
        print('Data {} Addr {} Data: {}'.format(addr,data,ctrl))

ir = RC6_M0(Pin(2, Pin.IN), callback)
print("UP")

#vol down 0,17
#vol up 0,16
while True:
    #nec.transmit(0,12)
    
    time.sleep_ms(30)
