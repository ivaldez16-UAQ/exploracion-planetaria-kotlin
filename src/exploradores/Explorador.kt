package exploradores

import utilidades.comoDistancia

abstract class Explorador(val nombre: String, energiaInicial: Int = 100, distanciaInicial: Double = 0.0) {
    var energia: Int = energiaInicial
        protected set(value) { field = value.coerceIn(0, 100) }

    var distancia: Double = distanciaInicial
        protected set

    val bateriaBaja: Boolean get() = energia < 20

    protected abstract val consumoBase: Int

    companion object { var contadorExploradores = 0 }

    init {
        contadorExploradores++
        println("Explorador '$nombre' creado con energía $energia%")
    }

    open fun desplazarse(km: Double) {
        if (bateriaBaja) { println("$nombre: batería baja, no puede moverse"); return }
        distancia += km
        energia -= (consumoBase * km).toInt()
        println("$nombre avanzó ${km.comoDistancia()} | energía: $energia%")
    }

    abstract fun explorar(): String
}