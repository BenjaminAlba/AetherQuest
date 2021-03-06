import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueRoom extends World 
{
    private static GreenfootSound music = new GreenfootSound("sounds/prologueOWS.mp3");
    public static final int OPEN = 1;
    public static final int CLOSED = 0;
    
    private CharacterNameProvider unknownName = new UnknownNameProvider();
    public static final int LEFT = 1;
    public static final int RIGHT = 0;
    public static final int UP = 0;
    public static final int DOWN = 1;
    private static int mapIconX = 0;
    private static int mapIconY = 0;
    private String id;
    private int upDoorY = 70;
    private int downDoorY = 650;
    private int verticalDoorX = 640;
    private int leftDoorX = 90;
    private int rightDoorX = 1190;
    private int horizontalDoorY = 360;
    private String characterId = "00";
    private MovingCharacter unknown;
    private ShortWall leftWall = new ShortWall(LEFT, "prologue");
    private ShortWall rightWall = new ShortWall(RIGHT, "prologue");
    private LongWall topWall = new LongWall(UP, "prologue");
    private LongWall bottomWall = new LongWall(DOWN, "prologue");
    private Image map = new Image("images/maps/map_prologue.png");
    private Image mapIcon = new Image("images/maps/map_icon.png");
    private Image darkenScreen = new Image("images/menu/background.png");
    private Image textBox;
    private GreenfootSound buttonPress;
    private DialogPortrait portrait;
    private DialogHeader header;
    private DialogLine line1;
    private DialogLine line2;
    private DialogLine line3;
    private DialogIcon icon;
    private DialogLocation locationDisplay;
    private Party party = Party.getInstance();
    private YesPromptButton yesButton;
    private YesButtonSelect yesButtonSelect;
    private NoPromptButton noButton;

    public PrologueRoom(String id, int characterX, int characterY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        File room = new File("rooms/prologue/"+id+".room");
        if(party.getMember1()==null)       
            characterId="00";        
        else
            characterId="0"+party.getMember1().getId();

        unknown = new MovingCharacter(characterId);
        setBackground("images/prologue_rf/floor.png");
        addObject(topWall, 640, 60);
        addObject(bottomWall, 640, 660);
        addObject(leftWall, 70, 360);
        addObject(rightWall, 1210, 360);
        textBox = new Image("images/dialog/dialog_box.png");
        icon = new DialogIcon();
        buttonPress = new GreenfootSound("sounds/button_click.mp3");
        this.id = id;
        if(id.equals("01")){
            mapIconX = 0;
            mapIconY = 0;
        }
        try{
            FileReader roomReader = new FileReader(room);
            BufferedReader bufferedRoomReader= new BufferedReader(roomReader);

            String linea = bufferedRoomReader.readLine();

            while(linea != null){
                switch(linea){
                    case "upDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueVerticalDoor(UP,linea),verticalDoorX,upDoorY);
                    break;
                    case "downDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueVerticalDoor(DOWN,linea),verticalDoorX,downDoorY);
                    break;
                    case "leftDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueHorizontalDoor(LEFT,linea),leftDoorX,horizontalDoorY);
                    break;
                    case "rightDoor":
                    linea = bufferedRoomReader.readLine();
                    addObject(new PrologueHorizontalDoor(RIGHT,linea),rightDoorX,horizontalDoorY);
                    break;
                    case "Sokudo":
                    if(party.getPartyFlags(4)==false && party.getPartyFlags(5)==false && !party.getPartyFlags(3)){
                        CharacterImage sokudo = new SokudoImage();
                        addObject(sokudo,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Light":
                    if(party.getPartyFlags(6)==false && party.getPartyFlags(7)==false && !party.getPartyFlags(3)){                    
                        CharacterImage light = new LightImage();
                        addObject(light,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Shock":
                    if(party.getPartyFlags(8)==false && party.getPartyFlags(9)==false && !party.getPartyFlags(3)){                    
                        CharacterImage shock = new ShockImage();
                        addObject(shock,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Mike":
                    if(party.getPartyFlags(10)==false && party.getPartyFlags(11)==false && !party.getPartyFlags(3)){                    
                        CharacterImage mike = new MikeImage();
                        addObject(mike,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Rengoku":
                    if(party.getPartyFlags(12)==false && party.getPartyFlags(13)==false && !party.getPartyFlags(3)){                    
                        CharacterImage rengoku = new RengokuImage();
                        addObject(rengoku,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "KingHermes":
                    if(party.getPartyFlags(14)==false && party.getPartyFlags(15)==false && !party.getPartyFlags(3)){                    
                        CharacterImage kingHermes = new KingHermesImage();
                        addObject(kingHermes,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Luis":
                    if(party.getPartyFlags(16)==false && party.getPartyFlags(17)==false && !party.getPartyFlags(3)){                    
                        CharacterImage luis = new LuisImage();
                        addObject(luis,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "Nagito":
                    if(party.getPartyFlags(18)==false && party.getPartyFlags(19)==false && !party.getPartyFlags(3)){                    
                        CharacterImage nagito = new NagitoImage();
                        addObject(nagito,640,360);
                    }
                    linea = bufferedRoomReader.readLine();
                    break;
                    case "trapDoor":
                    if(party.getPartyFlags(3) == false)
                        addObject(new PrologueTrapDoor(CLOSED),640,360);
                    else
                        addObject(new PrologueTrapDoor(OPEN),640,360);
                    linea = bufferedRoomReader.readLine();
                    break;
                    default:
                    linea = bufferedRoomReader.readLine();
                    break;
                }
            }

        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        addObject(unknown, characterX, characterY);
        map.setTransparency(100);
        addObject(map,145,135);
        mapIcon.setTransparency(200);
        addObject(mapIcon,85 + 10 * mapIconX,135 + 10 * mapIconY);
    }

    public static void addMapIconX(int number){
        mapIconX+=number;
    }

    public static void addMapIconY(int number){
        mapIconY+=number;
    }

    public void act(){
        
    }

    public void sokudoRecruitScene()
    {
        CharacterNameProvider sokudoName = new Sokudo();
        addObject(darkenScreen,640,360);
        showLocation("Primera celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("??Qui??n se acerca?","D??jame verte.","Qu?? extra??o...",unknownName);
            dialogChunk("Dime qu?? quieres.","[..]","[..]",unknownName);
            dialogChunk("Entiendo.","No queda m??s remedio que ayudarte.","S??lo prom??teme qu?? no cambiar??s",unknownName);
            dialogChunk("mis recuerdos.","[..]","[..]",unknownName);
            dialogChunk("??Mi magia nos sacar?? de aqu??!","","",sokudoName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(1),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(5) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("S??lo yo,","el mejor mago del reino.","Si eres sensato,",sokudoName);
            dialogChunk("te dar??s cuenta que soy","tu mejor opci??n.","",sokudoName);
            dialogChunk("??Y bien?","??Qu?? har??s?","",sokudoName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(5),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void lightRecruitScene()
    {
        CharacterNameProvider lightName = new Light();
        addObject(darkenScreen,640,360);
        showLocation("Segunda celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Ya me cans?? de estar encerrado.","[...]","??Eh...?",unknownName);
            dialogChunk("??Qui??n anda ah???","[..]","[..]",unknownName);
            dialogChunk("Ah, ya veo.","Dime qu?? buscas, y ver??","qu?? har?? contigo.",unknownName);
            dialogChunk("[...]","[..]","[..]",unknownName);
            dialogChunk("Vaya.","Es natural que requieras mi ayuda.","Despu??s de todo,",unknownName);
            dialogChunk("he sobrevivido cosas peores.","Y he estado esperando","una buena pelea.",lightName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(2),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(7) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("As?? que fuiste t?? qui??n","sali?? de su celda.","",lightName);
            dialogChunk("Est??s de suerte.","S??lo por hoy te ofrezco","mi espada.",lightName);
            dialogChunk("Ya discutiremos despu??s","los detalles del pago.","",lightName);
            dialogChunk("??Y bien?","??Qu?? har??s?","",lightName);
            dialogChunk("??Aceptar??s mi oferta?","","",lightName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(7),1021,287);
            removeObject(unknown);
        }

        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void shockRecruitScene()
    {
        CharacterNameProvider shockName = new Shock();
        addObject(darkenScreen,640,360);
        showLocation("Tercer celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Oye, t??.","No actues como si no te","hubieras dado cuenta.",unknownName);
            dialogChunk("Oye...","??Oye!","??No te vayas!",unknownName);
            dialogChunk("Por favor...","S??lo esc??chame,","??S???",unknownName);
            dialogChunk("Sab??a que no me ibas","a ignorar.","Ahora s??came de aqu??.",unknownName);
            dialogChunk("Estoy muy aburrido.","No he visto a la coneja","en muchos d??as.",shockName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(3),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(9) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("??Buenas!","??Qu?? gusto ver a alguien m??s!","",shockName);
            dialogChunk("Ya llevo mucho encerrado aqu??.","Ni siquiera s?? c??mo","termin?? en ??ste l??o",shockName);
            dialogChunk("pero estoy seguro","que podr?? ayudarte.","",shockName);
            dialogChunk("??Qu???","??Que en qu?? soy bueno?","Vaya que haces preguntas dif??ciles...",shockName);
            dialogChunk("??Qu?? ha dicho...?","Mucho texto.","",party.getMember1());

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(9),1021,287);
            removeObject(unknown);
        }

        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void mikeRecruitScene()
    {
        CharacterNameProvider mikeName = new Mike();
        addObject(darkenScreen,640,360);
        showLocation("Cuarta celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Al menos as?? puedo","mantenerme en forma.","[...]",unknownName);
            dialogChunk("[...]","[...]","Me has observado bastante.",unknownName);
            dialogChunk("??Mu??strate!","[...]","[...]",unknownName);
            dialogChunk("Est?? bien.","Te ayudar??, pero debes cumplir","tu parte.",unknownName);
            dialogChunk("Debes ayudarme a recuperar","mis recuerdos.","",unknownName);
            dialogChunk("Ay??dame a descibrir qui??n soy.","","",mikeName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(4),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(11) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("S??, estoy aqu??.","","",mikeName);
            dialogChunk("??C??mo te llamas?","","",party.getMember1());
            dialogChunk("No lo s??.","No recuerdo nada de mi pasado.","",mikeName);
            dialogChunk("S??lo tengo una placa","de la milicia.","",mikeName);
            dialogChunk("Creo que era...","mi nombre de soldado.","",mikeName);
            dialogChunk("'M1K3'","??Te suena de algo?","",mikeName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(11),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void rengokuRecruitScene()
    {
        CharacterNameProvider rengokuName = new Rengoku();
        addObject(darkenScreen,640,360);
        showLocation("Quinta celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("??Tienes miedo?","??Por qu?? tratabas de esconderte?","[...]",unknownName);
            dialogChunk("Ah, ya veo.","??Qu?? hace alguien como t?? aqu???","[...]",unknownName);
            dialogChunk("[...]","[...]","[...]",unknownName);
            dialogChunk("Muy bien.","Si tambi??n deseas","salvar a los dem??s...",unknownName);
            dialogChunk("Har?? lo que pueda","para ayudarte.","",unknownName);
            dialogChunk("No permitir?? que nadie muera.","","",rengokuName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(5),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(13) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("??T?? eres qui??n sali?? de su celda?","Me imagino tendr??s tus motivos","",rengokuName);
            dialogChunk("Pero si lo que dijo quien","nos ha encerrado es cierto,","entonces es peligroso explorar.",rengokuName);
            dialogChunk("Necesitar??s alguien que te ayude.","Curar es mi especialidad.","",rengokuName);
            dialogChunk("??Crees que te sirva de algo?","","",rengokuName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(13),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void kingHermesRecruitScene()
    {
        CharacterNameProvider kingHermesName = new KingHermes();
        addObject(darkenScreen,640,360);
        showLocation("Sexta celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("??Qu?? es eso?","??Obo?","??Qu?? es obo?",unknownName);
            dialogChunk("Hmmm...","No.","Simplemente no entiendo.",unknownName);
            dialogChunk("En fin.","Ya me tiene cansado","esta broma.",unknownName);
            dialogChunk("??En qu?? momento","me dejar??n salir?","Es la primera vez",unknownName);
            dialogChunk("que me hacen algo as??.","??Inaudito!","",unknownName);
            dialogChunk("D??jame decirte.","Tienes suerte que estoy","de buen humor",kingHermesName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(6),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(15) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("??Qu?? no me reconoces?","","",kingHermesName);
            dialogChunk("No.","","",party.getMember1());
            dialogChunk("??Pero qu?? imb??cil!","","",kingHermesName);
            dialogChunk("[...]","[...]","[...]",party.getMember1());
            dialogChunk("Vaya, quiz?? deb?? permitir que","los campesinos fueran a la escuela.","",kingHermesName);
            dialogChunk("En fin...","Soy tu rey, Hermes LXIX","",kingHermesName);
            dialogChunk("??Lib??rame en ??ste instante!","","",kingHermesName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(15),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void luisRecruitScene()
    {
        CharacterNameProvider luisName = new Luis();
        addObject(darkenScreen,640,360);
        showLocation("S??ptima celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("??Haz venido con la intenci??n","de comprar?","Es una l??stima.",unknownName);
            dialogChunk("No traigo nada conmigo.","[...]","Ah...",unknownName);
            dialogChunk("??No has venido a eso?","Entonces no tengo","nada que decirte.",unknownName);
            dialogChunk("[...]","[...]","[...]",unknownName);
            dialogChunk("Eres bastante insistente.","Vamos, te escucho.","[...]",unknownName);
            dialogChunk("As?? que s??lo fue mala suerte...","Tendr??s que compensarme","de alg??n modo.",unknownName);
            dialogChunk("Puedes empezar","por dejarme salir.","[...]",luisName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(7),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(17) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("S??lo un mercader desafortunado.","","",luisName);
            dialogChunk("Ten??a tantos pedidos por entregar","y termino en una celda miserable","en qui??n sabe d??nde.",luisName);
            dialogChunk("Ya discutiremos despu??s","los detalles del pago.","",luisName);
            dialogChunk("S?? que eres","qui??n puede sacarme de aqu??.","Dime tu precio.",luisName);
            dialogChunk("Estoy dispuesto a pagar lo necesario.","??S??lo s??came de aqu??!","",luisName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(17),1021,287);
            removeObject(unknown);
        }

        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void nagitoRecruitScene()
    {
        CharacterNameProvider nagitoName = new Nagito();
        addObject(darkenScreen,640,360);
        showLocation("Novena celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Est?? bien.","","",unknownName);
            dialogChunk("Esperar?? lo m??s que pueda.","","",unknownName);
            dialogChunk("Qu?? suerte tener tiempo,","??no crees?","",unknownName);
            dialogChunk("S??.","Me asegurar?? que as?? sea.","",unknownName);
            dialogChunk("pero t?? tambi??n debes","tener cuidado.","",unknownName);

            quickDialogChunk("Est?? bien.","","",unknownName);
            quickDialogChunk("Esperar?? lo m??s que pueda.","","",unknownName);
            quickDialogChunk("Qu?? suerte tener tiempo,","??no crees?","",unknownName);
            quickDialogChunk("S??.","Me asegurar?? que as?? sea.","",unknownName);
            quickDialogChunk("pero t?? tambi??n debes","tener cuidado.","",unknownName);

            quickDialogChunk("Est?? bien.","","",unknownName);
            quickDialogChunk("Esperar?? lo m??s que pueda.","","",unknownName);
            quickDialogChunk("Qu?? suerte tener tiempo,","??no crees?","",unknownName);
            quickDialogChunk("S??.","Me asegurar?? que as?? sea.","",unknownName);
            quickDialogChunk("pero t?? tambi??n debes","tener cuidado.","",unknownName);

            quickDialogChunk("Est?? bien.","","",unknownName);
            quickDialogChunk("Esperar?? lo m??s que pueda.","","",unknownName);
            quickDialogChunk("Qu?? suerte tener tiempo,","??no crees?","",unknownName);
            quickDialogChunk("S??.","Me asegurar?? que as?? sea.","",unknownName);
            quickDialogChunk("pero t?? tambi??n debes","tener cuidado.","",unknownName);

            quickDialogChunk("Est?? bien.","","",unknownName);
            quickDialogChunk("Esperar?? lo m??s que pueda.","","",unknownName);
            quickDialogChunk("Qu?? suerte tener tiempo,","??no crees?","",unknownName);
            quickDialogChunk("S??.","Me asegurar?? que as?? sea.","",unknownName);
            quickDialogChunk("pero t?? tambi??n debes","tener cuidado.","",unknownName);

            dialogChunk("No puedo perder.","","",nagitoName);
            dialogChunk("Esta voz...","??Acaso es m??a?","",unknownName);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(8),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(19) && !party.getPartyFlags(3))
        {
            dialogChunk("??Hay alguien ah???","","",party.getMember1());
            dialogChunk("No lo hagas.","","",nagitoName);
            dialogChunk("??De qu?? hablas?","","",party.getMember1());
            dialogChunk("No abras la celda.","","",nagitoName);
            dialogChunk("??Por qu???","??No quieres salir?","",party.getMember1());
            dialogChunk("Aunque...","No creo que sobrevivas solo.","",nagitoName);
            dialogChunk("No quiero que mueras.","","",nagitoName);
            dialogChunk("[??Deber??a dejarlo salir?]","","",party.getMember1());

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(19),1021,287);
            removeObject(unknown);
        }

        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void flagActions(int flag)
    {
        if(!party.getPartyFlags(1))
        {
            switch(flag)
            {
                case 5:
                party.setMember2(new Sokudo());
                break;
                case 7:
                party.setMember2(new Light());
                break;
                case 9:
                party.setMember2(new Shock());
                break;
                case 11:
                party.setMember2(new Mike());
                break;
                case 13:
                party.setMember2(new Rengoku());
                break;
                case 15:
                party.setMember2(new KingHermes());
                break;
                case 17:
                party.setMember2(new Luis());
                break;
                case 19:
                party.setMember2(new Nagito());
                break;
            }
            party.setPartyFlags(1);
            party.setPartyFlags(flag);
        }
        else if(!party.getPartyFlags(2))
        {
            switch(flag)
            {
                case 5:
                party.setMember3(new Sokudo());
                break;
                case 7:
                party.setMember3(new Light());
                break;
                case 9:
                party.setMember3(new Shock());
                break;
                case 11:
                party.setMember3(new Mike());
                break;
                case 13:
                party.setMember3(new Rengoku());
                break;
                case 15:
                party.setMember3(new KingHermes());
                break;
                case 17:
                party.setMember3(new Luis());
                break;
                case 19:
                party.setMember3(new Nagito());
                break;
            }
            party.setPartyFlags(2);
            party.setPartyFlags(flag);
        }
        else if(!party.getPartyFlags(3))
        {
            switch(flag)
            {
                case 5:
                party.setMember4(new Sokudo());
                break;
                case 7:
                party.setMember4(new Light());
                break;
                case 9:
                party.setMember4(new Shock());
                break;
                case 11:
                party.setMember4(new Mike());
                break;
                case 13:
                party.setMember4(new Rengoku());
                break;
                case 15:
                party.setMember4(new KingHermes());
                break;
                case 17:
                party.setMember4(new Luis());
                break;
                case 19:
                party.setMember4(new Nagito());
                break;
            }
            party.setPartyFlags(3);
            party.setPartyFlags(flag);
        }
        updateRoom();
    }

    public void addMovingCharacter(int xLocation, int yLocation)
    {
        if(party.getMember1()!=null)
            addObject(unknown = new MovingCharacter("0"+party.getMember1().getId()),xLocation,yLocation);
        else
            addObject(unknown = new MovingCharacter("00"),xLocation,yLocation);
    }

    public void setProtagonist(int id)
    {
        switch(id)
        {
            case 1:
            party.setMember1(new Sokudo());
            party.setPartyFlags(4);
            party.setPartyFlags(5);
            break;
            case 2:
            party.setMember1(new Light());
            party.setPartyFlags(6);
            party.setPartyFlags(7);
            break;
            case 3:
            party.setMember1(new Shock());
            party.setPartyFlags(8);
            party.setPartyFlags(9);
            break;
            case 4:
            party.setMember1(new Mike());
            party.setPartyFlags(10);
            party.setPartyFlags(11);
            break;
            case 5:
            party.setMember1(new Rengoku());
            party.setPartyFlags(12);
            party.setPartyFlags(13);
            break;
            case 6:
            party.setMember1(new KingHermes());
            party.setPartyFlags(14);
            party.setPartyFlags(15);
            break;
            case 7:
            party.setMember1(new Luis());
            party.setPartyFlags(16);
            party.setPartyFlags(17);
            break;
            case 8:
            party.setMember1(new Nagito());
            party.setPartyFlags(18);
            party.setPartyFlags(19);
            break;
        }
        party.setPartyFlags(0);
        Greenfoot.setWorld(new PrologueRoom(this.id,640,360));
    }

    public void updateRoom()
    {
        Greenfoot.setWorld(new PrologueRoom(this.id,640,360));
    }

    public void waitForInput()
    {
        Greenfoot.delay(20);
        while(!Greenfoot.isKeyDown("enter"));
        buttonPress.play(); 
        Greenfoot.delay(20);
    }

    public void quickWait()
    {
        Greenfoot.delay(50);
    }

    public void quickDialogChunk(String line1, String line2, String line3, CharacterNameProvider character)
    {
        addObject(textBox,644,549);
        addObject(portrait = new DialogPortrait(character),380,558);
        addObject(header = new DialogHeader(character),350,460);

        addObject(this.line1 = new DialogLine(line1,1),350,460);
        if(line2.isEmpty())
        {
            addObject(icon,973,634);
            quickWait();
        }
        else
        {
            quickWait();
            addObject(this.line2 = new DialogLine(line2,2),350,460);
            if(line3.isEmpty())
            {
                addObject(icon,973,634);
                quickWait();
            }else
            {
                quickWait();
                addObject(this.line3 = new DialogLine(line3,3),350,460);
                addObject(icon,973,634);
                quickWait();
            }
        }

        removeObject(this.line1);

        if(!line2.isEmpty())
        {
            removeObject(this.line2);
        }
        if(!line3.isEmpty())
        {
            removeObject(this.line3);
        }
        removeObject(textBox);
        removeObject(portrait);
        removeObject(header);
        removeObject(icon);
    }

    public void dialogChunk(String line1, String line2, String line3, CharacterNameProvider character)
    {
        addObject(textBox,644,549);
        addObject(portrait = new DialogPortrait(character),380,558);
        addObject(header = new DialogHeader(character),350,460);

        addObject(this.line1 = new DialogLine(line1,1),350,460);
        if(line2.isEmpty())
        {
            addObject(icon,973,634);
            waitForInput();
        }
        else
        {
            waitForInput();
            addObject(this.line2 = new DialogLine(line2,2),350,460);
            if(line3.isEmpty())
            {
                addObject(icon,973,634);
                waitForInput();
            }else
            {
                waitForInput();
                addObject(this.line3 = new DialogLine(line3,3),350,460);
                addObject(icon,973,634);
                waitForInput();
            }
        }

        removeObject(this.line1);

        if(!line2.isEmpty())
        {
            removeObject(this.line2);
        }
        if(!line3.isEmpty())
        {
            removeObject(this.line3);
        }
        removeObject(textBox);
        removeObject(portrait);
        removeObject(header);
        removeObject(icon);
    }

    public void showLocation(String location, boolean displayStatus)
    {
        if(displayStatus==true)
        {
            addObject(locationDisplay = new DialogLocation(location),350,460);
        }else
        {
            removeObject(locationDisplay);
        }
    }

    public static void playMusic(){
        music.playLoop();
    }

    public static void stopMusic(){
        music.stop();
    }
}
