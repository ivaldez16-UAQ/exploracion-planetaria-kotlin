package exploradores

import utilidades.comoDistancia
import utilidades.comoPorcentaje

abstract class Explorador(val nombre: String, energiaInicial: Int = 100, distanciaInicial: Double = 0.0) {
    var energia: Int = energiaInicial.coerceIn(0, 100)
        protected set(value) { field = value.coerceIn(0, 100) }

    var distancia: Double = distanciaInicial
        protected set

    val bateriaBaja: Boolean get() = energia < 20

    protected abstract val consumoBase: Int

    companion object { var contadorExploradores = 0 }

    init {
        contadorExploradores++
        println("🛰️ Explorador '$nombre' listo con ${energia.comoPorcentaje()} de energía")
    }

    open fun desplazarse(km: Double) {
        if (bateriaBaja) { alertaBateria(); return }
        distancia += km
        energia -= (consumoBase * km).toInt()
        println("$nombre avanzó ${km.comoDistancia()} | energía: ${energia.comoPorcentaje()}")
        if (bateriaBaja) alertaBateria()
    }

    fun recargar(cantidad: Int) {
        energia += cantidad
        println("🔋 $nombre se recargó. Energía: ${energia.comoPorcentaje()}")
    }

    fun alertaBateria() = println("⚠️ ALERTA : $nombre tiene la batería baja (${energia.comoPorcentaje()})")

    abstract fun explorar(): String
}