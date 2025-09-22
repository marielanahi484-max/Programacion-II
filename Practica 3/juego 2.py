import random
class Juego:
    def __init__(self, numero_de_vidas):
        self.numero_de_vidas = numero_de_vidas
        self.record = 0

    def reinicia_partida(self):
        print("\n¡Partida reiniciada!\n")

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

    def valida_numero(self, n):
        return 0 <= n <= 10

    def juega(self):
        self.reinicia_partida()
        self.numero_a_adivinar = random.randint(0, 10)

        while True:
            try:
                intento = int(input("Adivina un número entre 0 y 10: "))
            except ValueError:
                print("Por favor, ingresa un número válido.")
                continue

            if not self.valida_numero(intento):
                print("Número inválido. Debe estar entre 0 y 10.")
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
                elif intento < self.numero_a_adivinar:
                    print("El número a adivinar es mayor.")
                else:
                    print("El número a adivinar es menor.")

class JuegoAdivinaPar(JuegoAdivinaNumero):
    def valida_numero(self, n):
        if 0 <= n <= 10 and n % 2 == 0:
            return True
        elif 0 <= n <= 10:
            print("Error: Solo se permiten números pares.")
            return False
        else:
            print("Error: El número debe estar entre 0 y 10.")
            return False


class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def valida_numero(self, n):
        if 0 <= n <= 10 and n % 2 == 1:
            return True
        elif 0 <= n <= 10:
            print("Error: Solo se permiten números impares.")
            return False
        else:
            print("Error: El número debe estar entre 0 y 10.")
            return False

def main():
    print("========== Juego Adivina Número ==========")
    juego1 = JuegoAdivinaNumero(3)
    juego1.juega()

    print("\n========== Juego Adivina Par ==========")
    juego2 = JuegoAdivinaPar(3)
    juego2.juega()

    print("\n========== Juego Adivina Impar ==========")
    juego3 = JuegoAdivinaImpar(3)
    juego3.juega()

if __name__ == "__main__":
    main()
