from machine import Pin,SPI
import framebuf
import time
from screen import OLED_1inch3
DC = 8
RST = 12
MOSI = 11
SCK = 10
CS = 9


if __name__=='__main__':

    OLED = OLED_1inch3()
 
 
    
    time.sleep(1)
    OLED.fill(0x0000) 
    keyA = Pin(15,Pin.IN,Pin.PULL_UP)
    keyB = Pin(17,Pin.IN,Pin.PULL_UP)
    while(1):
        if keyA.value() == 0:
            OLED.fill_rect(0,0,128,20,OLED.white)
            print("A")
        else :
            OLED.fill_rect(0,0,128,20,OLED.balck)
            
            
        if(keyB.value() == 0):
            OLED.fill_rect(0,44,128,30,OLED.white)
            print("B")
        else :
            OLED.fill_rect(0,44,128,20,OLED.balck)
        OLED.fill_rect(0,22,128,20,OLED.white)
        OLED.text("press the button",0,20,OLED.balck)
            
        OLED.show()
    
    
    time.sleep(1)
    OLED.fill(0xFFFF)





