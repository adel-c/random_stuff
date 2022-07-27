from machine import Pin,SPI
import framebuf
import time
from screen import OLED_1inch3
from pomodoro import Pomodoro
DC = 8
RST = 12
MOSI = 11
SCK = 10
CS = 9



if __name__=='__main__':

    OLED = OLED_1inch3()
    pomodoro = Pomodoro()


    time.sleep(1)
    OLED.fill(0x0000)
    keyA = Pin(15,Pin.IN,Pin.PULL_UP)
    keyB = Pin(17,Pin.IN,Pin.PULL_UP)
    while(1):
        pomodoro.update()
        if keyA.value() == 0:
            if pomodoro.status() != Pomodoro.START:
                pomodoro.start()

        if(keyB.value() == 0):
            if pomodoro.status() == Pomodoro.START:
                pomodoro.short_pause()
                
            elif pomodoro.status() == Pomodoro.PAUSE_SHORT:
                pomodoro.stop()

        OLED.fill_rect(0,0,128,44,OLED.balck)
        if pomodoro.status() == Pomodoro.WAITING:
            OLED.text("Key 0 to start",0,20,OLED.white)
        
        else:
            stateMessage= "WORK"
            if pomodoro.status() == Pomodoro.PAUSE_SHORT:
                stateMessage= "PAUSE"
            OLED.text(stateMessage.center(16),0,20,OLED.white)
            timeleft =pomodoro.time_left_in_sec()
            message= "{0:02d}m{1:02d}s".format(timeleft // 60 , timeleft % 60)
          
            OLED.fill_rect(0,40,128,44,OLED.balck)
            OLED.text(message.center(16),0,40,OLED.white)

        OLED.show()
        time.sleep(0.3)


    time.sleep(1)
    OLED.fill(0xFFFF)





