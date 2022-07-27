from machine import UART, Pin
import time
UART_Tx_BUFFER_LENGTH = 1024
UART_Rx_BUFFER_LENGTH = 1024*2
uart0= UART(0, baudrate=115200, tx=Pin(0), rx=Pin(1),txbuf=UART_Tx_BUFFER_LENGTH, rxbuf=UART_Rx_BUFFER_LENGTH)

#while True:
#    rxData = bytes()
#    while uart0.any() > 0 :
#        rxData +=uart0.read(1)
#    if len(rxData):
#        print(rxData,end='')
def command(string):
    print("#####################")
    txData=str()
    txData+=string
    print("sending:"+txData) 
    uart0.write(txData+""+"\r\n")
    rxData=bytes()
    
    while True:
        time.sleep(0.5)
        if uart0.any()>0:
            print("loop1")
            break
    while uart0.any()>0:
        print("loop2")   
        rxData += uart0.read(UART_Rx_BUFFER_LENGTH)
        
    print (rxData);
    print("#####################")
    return rxData.decode('utf-8')

currentMode="AT+CWMODE_CUR?"
connect='AT+CWJAP="'+'Astera'+'","'+'aceace33'+'"'
version="AT+GMR"
reset="AT+RESTORE"
start="AT"
stationMode="AT+CWMODE_CUR=1"
stationMode2="AT+CWMODE=1"
#print(command(reset))
print(command(start))
print(command(version))
print(command(stationMode2))
print(command(connect))  