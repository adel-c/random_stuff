from machine import Pin, I2C
from ssd1306 import SSD1306_I2C
import framebuf,sys


pix_res_x  = 128 # SSD1306 horizontal resolution
pix_res_y = 64   # SSD1306 vertical resolution

i2c_dev = I2C(0,sda=Pin(8),scl=Pin(9),freq=400000)  # start I2C on I2C1 (GPIO 26/27)
i2c_addr = [hex(ii) for ii in i2c_dev.scan()] # get I2C address in hex format
if i2c_addr==[]:
    print('No I2C Display Found') 
    sys.exit() # exit routine if no dev found
else:
    print("I2C Address      : {}".format(i2c_addr[0])) # I2C device address
    print("I2C Configuration: {}".format(i2c_dev)) # print I2C params


oled = SSD1306_I2C(pix_res_x, pix_res_y, i2c_dev) # oled controller

# Raspberry Pi logo as 32x32 bytearray


# Clear the oled display in case it has junk on it.
oled.fill(0)



# Add some text
oled.text("Raspberry Pi",5,5)
oled.text("Pico",5,15)
oled.hline(0,0,128,1)
oled.vline(0,0,64,1)
oled.vline(127,0,64,1)
oled.hline(0,63,128,1)
# Finally update the oled display so the image & text is displayed
oled.show()
