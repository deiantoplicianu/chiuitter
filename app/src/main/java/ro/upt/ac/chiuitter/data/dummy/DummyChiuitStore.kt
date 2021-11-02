package ro.upt.ac.chiuitter.data.dummy

import ro.upt.ac.chiuitter.domain.ChiuitRepository
import ro.upt.ac.chiuitter.domain.Chiuit

class DummyChiuitStore : ChiuitRepository {

    override fun getAll(): List<Chiuit> =
            listOf(
                    Chiuit(0,"Ada-mi Doamne, timpu-odata\n" +
                            "Sa-mi vad tara mea bogata,\n" +
                            "Cei campi si munti inverziti\n" +
                            "Dulci surori si frati iubiti."),
                    Chiuit(1,"Vai de mine multe știu\n" +
                            "și mă mir unde le țiu;\n" +
                            "da’ le țiu într-o poiată\n" +
                            "și le slobod câteodată,\n" +
                            "când îi mândra supărată"),
                    Chiuit(2,"Cui nu i-s dragi horile,\n" +
                            "bată-l sărbătorile,\n" +
                            "că pe mine nu m-or bate\n" +
                            "că horesc și zi și noapte\n" +
                            "și-oi hori până la moarte,\n" +
                            "să-mi horesc horile toate"),
                    Chiuit(3, "Cine nu umblă la joc\n" +
                            "crește ca un dobitoc,\n" +
                            "nu știe râde, nici glumi,\n" +
                            "parcă-i muma pădurii"),
                    Chiuit(4, "Decât c-o ceteră rea,\n" +
                            "mai bine cu gura mea.\n" +
                            "\n" +
                            "Cetera-i cu patru strune\n" +
                            "și mai rele și mai bune…\n" +
                            "\n" +
                            "Gura mea toate le spune;\n" +
                            "cetera mai și greșește…\n" +
                            "gura mea le potrivește!"),
                    Chiuit(5,"Frunză verde lemn uscat\n" +
                            "de strigat m-am săturat"))

    override fun addChiuit(chiuit: Chiuit) {
    }

    override fun removeChiuit(chiuit: Chiuit) {
    }
}