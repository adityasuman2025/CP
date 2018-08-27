import hello
import random

user = "Hello world"
print(user[-1]);

list = [1,2,3,4,5,6,7]

print(list)

classmates = {'Tony': " is a boy", 'Emma': " sits behind me"}
print(classmates['Tony'])

for k,v in classmates.items():
	print(k + v)

x = random.randrange(1,1000)
print(x)

class Enemy(object):
	life = 3

	def __init__(self, x):
		self.life = x
		print(self.life)

	def attack(self):
		print("ouch!!")
		self.life -=1

	def check(self):
		print(self.life)


enemy1 = Enemy(500)
enemy1.attack()
enemy1.check()