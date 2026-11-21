package exploradores

import modelo.Comunicable

class RoverTerrestre(nombre: String) : Explorador(nombre), Comunicable {
    override val consumoBase = 5
    override fun explorar() = "$nombre analiza muestras de suelo congelado"
    override fun transmitir(mensaje: String) = println("Rover $nombre transmite: $mensaje")
}

class DronExplorador(nombre: String) : Explorador(nombre, energiaInicial = 90), Comunicable {
    override val consumoBase = 3
    override fun desplazarse(km: Double) {
        println("$nombre sobrevuela el terreno")
        super.desplazarse(km)
    }
    override fun explorar() = "$nombre fotografía la superficie desde el aire"
    override fun transmitir(mensaje: String) = println("Dron $nombre transmite: $mensaje")
}

class SubmarinoExplorador(nombre: String) : Explorador(nombre, energiaInicial = 80), Comunicable {
    override val consumoBase = 4
    override fun desplazarse(km: Double) {
        println("$nombre se sumerge en el océano subterráneo ")
        super.desplazarse(km)
    }
    override fun explorar() = "$nombre toma muestras de agua a gran profundidad"
    override fun transmitir(mensaje: String) = println("Submarino $nombre transmite: $mensaje")
}