import math
class VectorTridimensional:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z
    def suma(self, v):
        return VectorTridimensional(self.x + v.x, self.y + v.y, self.z + v.z)
    def escalar(self, r):
        return VectorTridimensional(self.x * r, self.y * r, self.z * r)
    def norma(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)
    def normalizado(self):
        n = self.norma()
        if n == 0:
            return VectorTridimensional(0, 0, 0)
        return VectorTridimensional(self.x / n, self.y / n, self.z / n)
    def producto_punto(self, v):
        return self.x * v.x + self.y * v.y + self.z * v.z
    def producto_cruz(self, v):
        return VectorTridimensional(
            self.y * v.z - self.z * v.y,
            self.z * v.x - self.x * v.z,
            self.x * v.y - self.y * v.x)
    def es_paralelo(self, v):
        return self.producto_cruz(v).norma() < 1e-6
    def __str__(self):
        return f"({self.x}, {self.y}, {self.z})"
if __name__ == "__main__":
    a = VectorTridimensional(3, 4, 0)
    b = VectorTridimensional(-4, 3, 0)
    print("Vector a:", a)
    print("Vector b:", b)
    print("Suma a + b:", a.suma(b))
    print("Producto punto a · b:", a.producto_punto(b))
    print("Producto cruz a × b:", a.producto_cruz(b))
    print("Norma de a:", a.norma())
    print("Vector a normalizado:", a.normalizado())
    print("Vector b normalizado:", b.normalizado())
    print("a escalado por 2:", a.escalar(2))
    print("¿Son paralelos a y b?", a.es_paralelo(b))
