import control.CentroControl
import exploradores.*
import modelo.*

fun main() {
    println("=== MISIÓN EUROPA === ")
    val rover = RoverTerrestre("Atlas")
    val dron = DronExplorador("Colibrí")
    val submarino = SubmarinoExplorador("Neptuno")

    rover.desplazarse(8.0)
    dron.desplazarse(12.0)
    submarino.desplazarse(6.0)
    rover.desplazarse(9.0)   // provoca la alerta de batería baja
    rover.recargar(50)

    CentroControl.registrar(rover.explorar())
    CentroControl.registrar(submarino.explorar())

    val hallazgo = Descubrimiento("Hielo con minerales", TipoZona.ROCOSA, 7)
    CentroControl.registrar(hallazgo)
    CentroControl.registrar(hallazgo.copy(nombre = "Hielo con minerales (muestra 2)", zona = TipoZona.PELIGROSA))

    rover.transmitir("Muestras recolectadas")
    dron.transmitir("Zona despejada")
    submarino.transmitir("Detecto actividad térmica")

    println("\nExploradores creados: ${Explorador.contadorExploradores}")
    CentroControl.resumen()
}