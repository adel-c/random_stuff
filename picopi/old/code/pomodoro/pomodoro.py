import time
class Pomodoro:
    WAITING = 0
    START = 1
    PAUSE_SHORT = 2
    state = WAITING
    start_time = 0

    def start(self):
        self.start_time = time.time()
        self.state = Pomodoro.START
        
    def short_pause(self):
        self.start_time = time.time()
        self.state = Pomodoro.PAUSE_SHORT
    def stop(self):
        self.start_time = 0
        self.state = Pomodoro.WAITING

    def status(self):
        return self.state

    def time_left_in_sec(self):
        time_passed = time.time() - self.start_time

        if self.state == Pomodoro.START:
            return (25 * 60) - time_passed
        elif self.state == Pomodoro.PAUSE_SHORT:
            return (5 * 60) - time_passed
        else:
            return 0

    def update(self):
        timeleft = self.time_left_in_sec()
        if timeleft > 0:
            return

        if self.state == Pomodoro.START:
            self.short_pause()
        elif self.state == Pomodoro.PAUSE_SHORT:
            self.start()



if __name__ == '__main__':
    pomo = Pomodoro()
    print(pomo.status())
    pomo.start()

    print(pomo.status())
    print(pomo.time_left_in_sec())

