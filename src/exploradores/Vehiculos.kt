package exploradores

import modelo.Comunicable

class RoverTerrestre(nombre: String) : Explorador(nombre), Comunicable {
    override val consumoBase = 5
    override fun explorar() = "$nombre analiza muestras de suelo"
    override fun transmitir(mensaje: String) = println("Rover $nombre transmite: $mensaje")
}

class DronExplorador(nombre: String) : Explorador(nombre, energiaInicial = 90), Comunicable {
    override val consumoBase = 3
    override fun desplazarse(km: Double) { println("$nombre sobrevuela el terreno"); super.desplazarse(km) }
    override fun explorar() = "$nombre fotografía el terreno desde el aire"
    override fun transmitir(mensaje: String) = println("Dron $nombre transmite: $mensaje")
}