import threading
import random

class Character:
    def __init__(self, name, health, attack_power, defense_power):
        self.name = name
        self.max_health = health
        self.attack_power = attack_power
        self.defense_power = defense_power
        self.lock = threading.Lock()

    def character_attack(self, target):
        damage = random.randint(1, self.attack_power)
        with target.lock:
            target.max_health -= damage
            print(f"{self.name} attacks {target.name} for {damage} points of damage.")
            if target.max_health <= 0:
                print(f"{target.name} has been defeated!")

    def character_defend(self, incoming_damage):
        reduced_damage = max(0, incoming_damage - random.randint(1, self.defense_power))
        with self.lock:
            self.max_health -= reduced_damage
            print(f"{self.name} defends against {incoming_damage} damage, reducing it to {reduced_damage}.")
            if self.max_health <= 0:
                print(f"{self.name} has been defeated!")


