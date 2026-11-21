# Exploración Planetaria

Simulador en consola hecho en Kotlin. Controlo tres vehículos (rover, dron y submarino) que exploran la luna Europa, gastan batería y reportan sus hallazgos a un centro de control.

## Organización

```
src/
├── Main.kt                  → arranca la simulación
├── exploradores/
│   ├── Explorador.kt        → clase abstracta base
│   └── Vehiculos.kt         → Rover, Dron y Submarino
├── modelo/
│   └── Modelo.kt            → Descubrimiento, TipoZona, Comunicable
├── control/
│   └── control.kt           → CentroControl
└── utilidades/
    └── Extensiones.kt       → funciones de formato
```

## Conceptos aplicados

- **Constructor primario y parámetros predeterminados:** `Explorador` se crea solo con el nombre; energía y distancia ya traen valor.
- **init:** muestra un mensaje cuando nace cada vehículo.
- **Getter y setter personalizados:** `bateriaBaja` se calcula al momento y `energia` se mantiene entre 0 y 100.
- **Herencia, clase abstracta, open y override:** los tres vehículos comparten la base y cada uno explora a su manera.
- **Interfaz:** `Comunicable` les da a todos la habilidad de transmitir.
- **data class y enum class:** `Descubrimiento` guarda los hallazgos y `TipoZona` limita los terrenos posibles.
- **Funciones de extensión:** `comoDistancia()` y `comoPorcentaje()` para imprimir mejor los números.
- **object y companion object:** `CentroControl` es único y `contadorExploradores` cuenta los vehículos creados.
- **private y protected:** nadie fuera de la jerarquía puede cambiar la energía.
- **Paquetes:** el código está separado por responsabilidad.

## Reflexión

**1. ¿Clase u objeto?**
La clase es el molde y el objeto es lo que se crea con él.

**2. ¿val o var?**
`val` no se reasigna y `var` sí por su definición.

**3. ¿Para qué sirven los parámetros predeterminados?**
Para no escribir varios constructores.

**4. ¿Para qué usé init?**
Para mostrar un mensaje al crear cada vehículo.

**5. ¿Por qué una clase abstracta?**
Porque un explorador genérico no existe, solo sus tipos concretos.

**6. ¿Qué heredaron las subclases?**
Nombre, energía, distancia, `desplazarse()` y `recargar()`.

**7. ¿Qué sobrescribí?**
`consumoBase` y `explorar()`, y `desplazarse()` en el dron y el submarino.

**8. ¿Qué representa la interfaz?**
La habilidad de comunicarse.

**9. ¿Por qué interfaz y no herencia?**
Porque una clase solo hereda de una, pero puede implementar varias interfaces.

**10. ¿Ventaja de la data class?**
Trae `toString()` y `copy()` ya hechos.

**11. ¿Ventaja del enum?**
Evita zonas inválidas.

**12. ¿Qué hacen las funciones de extensión?**
Dan formato de texto a números ("12.0 km", "85%").

**13. ¿Qué es CentroControl?**
El único centro de la misión, con su bitácora.

**14. ¿Qué puse en el companion object?**
El contador de vehículos, porque es un dato de la clase.

**15. ¿object o companion object?**
El `object` existe solo; el `companion object` vive dentro de una clase.

**16. ¿Qué protegí?**
Los setters de `energia` y `distancia`, y `consumoBase`.

**17. ¿Cómo organicé los paquetes?**
Por función: vehículos, datos, control y utilidades.

**18. ¿Cómo agrego otro explorador?**
Creo una subclase de `Explorador`, sin tocar lo demás.
