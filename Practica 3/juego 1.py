import random
class Juego:
    def __init__(self, numero_de_vidas):
        self.numero_de_vidas = numero_de_vidas
        self.record = 0

    def reinicia_partida(self):
        print("¡Partida reiniciada!")

    def actualiza_record(self):
        if self.numero_de_vidas > self.record:
            self.record = self.numero_de_vidas
            print(f"¡Nuevo récord: {self.record} vidas restantes!")
        else:
            print(f"Récord no superado. Tu mejor marca sigue siendo: {self.record}")

    def quita_vida(self):
        self.numero_de_vidas -= 1
        if self.numero_de_vidas > 0:
            print(f"¡Te quedan {self.numero_de_vidas} vidas!")
            return True
        else:
            print("No te quedan más vidas.")
            return False
class JuegoAdivinaNumero(Juego):
    def __init__(self, numero_de_vidas):
        super().__init__(numero_de_vidas)
        self.numero_a_adivinar = None

    def juega(self):
        self.reinicia_partida()
        self.numero_a_adivinar = random.randint(0, 10)

        while True:
            try:
                intento = int(input("Adivina un número entre 0 y 10: "))
            except ValueError:
                print("Por favor, ingresa un número válido.")
                continue

            if intento == self.numero_a_adivinar:
                print("¡Acertaste!")
                self.actualiza_record()
                break
            else:
                quedan_vidas = self.quita_vida()

                if not quedan_vidas:
                    print(f"¡Perdiste! El número era: {self.numero_a_adivinar}")
                    break

                if intento < self.numero_a_adivinar:
                    print("El número a adivinar es mayor.")
                else:
                    print("El número a adivinar es menor.")

def main():
    juego = JuegoAdivinaNumero(numero_de_vidas=3)
    juego.juega()

if __name__ == "__main__":
    main()
