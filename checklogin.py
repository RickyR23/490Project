import sys

# Get username and password from sendlogin in userLoginActivity
username = sys.stdin.readline().strip()
password = sys.stdin.readline().strip()

if username == 'admin' & password == 'password':
    print('correct login') #test code