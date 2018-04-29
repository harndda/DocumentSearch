import java.io.File

class InputFiles {
    companion object {
        @JvmStatic
        internal fun getFiles() : ArrayList<File> {
            return arrayListOf(
                    File("hitchhikers.txt"),
                    File("warp_drive.txt"),
                    File("french_armed_forces.txt")
            )
        }
    }
}