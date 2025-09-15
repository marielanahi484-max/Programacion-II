import math
class AlgebraVectorial:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z
    def producto_punto(self, v):
        return self.x * v.x + self.y * v.y + self.z * v.z
    def producto_cruz(self, v):
        return AlgebraVectorial(
            self.y * v.z - self.z * v.y,
            self.z * v.x - self.x * v.z,
            self.x * v.y - self.y * v.x)
    def magnitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)
    def suma(self, v):
        return AlgebraVectorial(self.x + v.x, self.y + v.y, self.z + v.z)
    def resta(self, v):
        return AlgebraVectorial(self.x - v.x, self.y - v.y, self.z - v.z)
    def es_perpendicular(self, v):
        return abs(self.producto_punto(v)) < 1e-6
    def es_perpendicular_metodo1(self, v):
        return abs(self.suma(v).magnitud() - self.resta(v).magnitud()) < 1e-6
    def es_paralelo_metodo2(self, v):
        return self.producto_cruz(v).magnitud() < 1e-6
    def proyeccion_sobre(self, v):
        escalar = self.producto_punto(v) / (v.magnitud()**2)
        return AlgebraVectorial(v.x * escalar, v.y * escalar, v.z * escalar)
    def componente_en_direccion_de(self, v):
        return self.producto_punto(v) / v.magnitud()
    def __str__(self):
        return f"({self.x}, {self.y}, {self.z})"
if __name__ == "__main__":
    a = AlgebraVectorial(3, 4, 0)
    b = AlgebraVectorial(-4, 3, 0)
    print("Vector a:", a)
    print("Vector b:", b)
    print("¿Son perpendiculares (producto punto)?", a.es_perpendicular(b))
    print("¿Son perpendiculares (|a+b| = |a-b|)?", a.es_perpendicular_metodo1(b))
    print("¿Son paralelos (producto cruz = 0)?", a.es_paralelo_metodo2(b))
    print("Proyeccion de a sobre b:", a.proyeccion_sobre(b))
    print("Componente de a en direccion de b:", a.componente_en_direccion_de(b))

    
