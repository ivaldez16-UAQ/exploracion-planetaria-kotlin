package modelo

enum class TipoZona { SEGURA, ROCOSA, PELIGROSA }

data class Descubrimiento(val nombre: String, val zona: TipoZona, val valorCientifico: Int)

interface Comunicable {
    fun transmitir(mensaje: String)
}