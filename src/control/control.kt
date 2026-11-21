package control

import modelo.Descubrimiento

object CentroControl {
    private val bitacora = mutableListOf<String>()
    private val descubrimientos = mutableListOf<Descubrimiento>()

    fun registrar(mensaje: String) { bitacora.add(mensaje); println("[CONTROL] $mensaje") }
    fun registrar(d: Descubrimiento) { descubrimientos.add(d); registrar("Descubrimiento: $d") }
    fun resumen() = println("Descubrimientos totales: ${descubrimientos.size}")
}