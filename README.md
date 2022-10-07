Resumidamente, <br>
Preparo os diferentes layouts (sem seguir aquele modelo que nomeia as pastas com a largura da janela. Ex: res/layout-w600dp/nome.xml); <br>
    Ex: <br>
        main_activity_phone_port.xml <br>
        main_activity_phone_land.xml <br>
        main_activity_tablet_port.xml <br>
        main_activity_tablet_land.xml <br>

Na activity configuro "um" método que calcula a largura e a altura da JANELA em dp, classifica largura e altura em classes
(compact, medium e expaned) e ,por fim, seta o layout de acordo com as classes da largura e da altura.
