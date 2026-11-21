import control.CentroControl
import exploradores.*
import modelo.*

fun main() {
    val rover = RoverTerrestre("Curiosity-X")
    val dron = DronExplorador("Skyline-1")

    rover.desplazarse(10.0)
    dron.desplazarse(15.0)
    CentroControl.registrar(rover.explorar())
    CentroControl.registrar(Descubrimiento("Cristal de hielo", TipoZona.ROCOSA, 8))

    rover.transmitir("Muestra recolectada")
    dron.transmitir("Zona despejada")

    println("Exploradores creados: ${Explorador.contadorExploradores}")
    CentroControl.resumen()
}