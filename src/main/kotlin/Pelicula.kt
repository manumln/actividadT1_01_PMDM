class Pelicula(
    var titulo: String,
    var director: String,
    var genero: String
)
{
    override fun toString(): String {
        return "Pelicula(titulo='$titulo', director='$director', genero='$genero')"
    }
}

fun main() {
    val peliculaMap = mutableMapOf<Int, Pelicula>()
    var contador = 1

    while (true) {
        println("Menú:")
        println("1. Agregar película")
        println("2. Mostrar las películas")
        println("3. Buscar película por código")
        println("4. Borrar película por código")
        println("5. Editar película por código")
        println("6. Salir")
        print("Selecciona una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Título de la película: ")
                val titulo = readLine() ?: ""
                print("Director: ")
                val director = readLine() ?: ""
                print("Genero: ")
                val genero = readLine() ?: ""

                val pelicula = Pelicula(titulo, director, genero)
                peliculaMap[contador++] = pelicula
                println("Película agregada")
            }
            3 -> {
                print("Ingresa el código de la película que quieres buscar")
                val codigo = readLine()?.toIntOrNull()
                val pelicula = peliculaMap[codigo]
                if (pelicula != null) {
                    println("Película encontrada:")
                    println(pelicula)
                } else {
                    println("Película no encontrada.")
                }
            }
            4 -> {
                print("Ingresa el código de la película que quieras borrar ")
                val codigo = readLine()?.toIntOrNull()
                val pelicula = peliculaMap.remove(codigo)
                if (pelicula != null) {
                    println("Película borrada")
                } else {
                    println("Película no encontrada.")
                }
            }
            5 -> {
                print("Ingresa el código de la película que quieres editar ")
                val codigo = readLine()?.toIntOrNull()
                val pelicula = peliculaMap[codigo]
                if (pelicula != null) {
                    print("Nuevo título de la película: ")
                    val nuevoTitulo = readLine() ?: ""
                    print("Nuevo director de la película: ")
                    val nuevoDirector = readLine() ?: ""
                    print("Nuevo género: ")
                    val nuevoGenero = readLine() ?: ""

                    pelicula.titulo = nuevoTitulo
                    pelicula.director = nuevoDirector
                    pelicula.genero = nuevoGenero

                    println("Película editada")
                } else {
                    println("Película no encontrada.")
                }
            }
            6 -> {
                println("Saliendo del programa.")
                return
            }
            else -> {
                println("Opción no válida.")
            }
        }
    }
}