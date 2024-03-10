import threading
import time

def delayed_print (d):
    time.sleep(d)
    print(f"Hello {d}")

thread_one = threading.Thread(target=delayed_print, args=(5,))
thread_two = threading.Thread(target=delayed_print, args=(3,))

thread_one.start()
thread_two.start()

thread_one.join()
thread_two.join()