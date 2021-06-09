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
    private static GreenfootSound prologueMusic = new GreenfootSound("sounds/prologueOWS.mp3");
    public static final int OPEN = 1;
    public static final int CLOSED = 0;
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
        addObject(darkenScreen,640,360);
        showLocation("Primera celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("¿Quién se acerca?","Déjame verte.","Qué extraño...",0);
            dialogChunk("Dime qué quieres.","[..]","[..]",0);
            dialogChunk("Entiendo.","No queda más remedio que ayudarte.","Sólo prométeme qué no cambiarás",0);
            dialogChunk("mis recuerdos.","[..]","[..]",0);
            dialogChunk("¡Mi magia nos sacará de aquí!","","",1);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(1),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(5) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("Sólo yo,","el mejor mago del reino.","Si eres sensato,",1);
            dialogChunk("te darás cuenta que soy","tu mejor opción.","",1);
            dialogChunk("¿Y bien?","¿Qué harás?","",1);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(5),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void lightRecruitScene()
    {
        addObject(darkenScreen,640,360);
        showLocation("Segunda celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Ya me cansé de estar encerrado.","[...]","¿Eh...?",0);
            dialogChunk("¿Quién anda ahí?","[..]","[..]",0);
            dialogChunk("Ah, ya veo.","Dime qué buscas, y veré","qué haré contigo.",0);
            dialogChunk("[...]","[..]","[..]",0);
            dialogChunk("Vaya.","Es natural que requieras mi ayuda.","Después de todo,",0);
            dialogChunk("he sobrevivido cosas peores.","Y he estado esperando","una buena pelea.",2);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(2),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(7) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("Así que fuiste tú quién","salió de su celda.","",2);
            dialogChunk("Estás de suerte.","Sólo por hoy te ofrezco","mi espada.",2);
            dialogChunk("Ya discutiremos después","los detalles del pago.","",2);
            dialogChunk("¿Y bien?","¿Qué harás?","",2);
            dialogChunk("¿Aceptarás mi oferta?","","",2);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(7),1021,287);
            removeObject(unknown);
        }

        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void shockRecruitScene()
    {
        addObject(darkenScreen,640,360);
        showLocation("Tercer celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Oye, tú.","No actues como si no te","hubieras dado cuenta.",0);
            dialogChunk("Oye...","¡Oye!","¡No te vayas!",0);
            dialogChunk("Por favor...","Sólo escúchame,","¿Sí?",0);
            dialogChunk("Sabía que no me ibas","a ignorar.","Ahora sácame de aquí.",0);
            dialogChunk("Estoy muy aburrido.","No he visto a la coneja","en muchos días.",3);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(3),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(9) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("¡Buenas!","¡Qué gusto ver a alguien más!","",3);
            dialogChunk("Ya llevo mucho encerrado aquí.","Ni siquiera sé cómo","terminé en éste lío",3);
            dialogChunk("pero estoy seguro","que podré ayudarte.","",3);
            dialogChunk("¿Qué?","¿Que en qué soy bueno?","Vaya que haces preguntas difíciles...",3);
            dialogChunk("¿Qué ha dicho...?","Mucho texto.","",party.getMember1().getId());

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(9),1021,287);
            removeObject(unknown);
        }

        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void mikeRecruitScene()
    {
        addObject(darkenScreen,640,360);
        showLocation("Cuarta celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Al menos así puedo","mantenerme en forma.","[...]",0);
            dialogChunk("[...]","[...]","Me has observado bastante.",0);
            dialogChunk("¡Muéstrate!","[...]","[...]",0);
            dialogChunk("Está bien.","Te ayudaré, pero debes cumplir","tu parte.",0);
            dialogChunk("Debes ayudarme a recuperar","mis recuerdos.","",0);
            dialogChunk("Ayúdame a descibrir quién soy.","","",4);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(4),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(11) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("Sí, estoy aquí.","","",4);
            dialogChunk("¿Cómo te llamas?","","",party.getMember1().getId());
            dialogChunk("No lo sé.","No recuerdo nada de mi pasado.","",4);
            dialogChunk("Sólo tengo una placa","de la milicia.","",4);
            dialogChunk("Creo que era...","mi nombre de soldado.","",4);
            dialogChunk("'M1K3'","¿Te suena de algo?","",4);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(11),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void rengokuRecruitScene()
    {
        addObject(darkenScreen,640,360);
        showLocation("Quinta celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("¿Tienes miedo?","¿Por qué tratabas de esconderte?","[...]",0);
            dialogChunk("Ah, ya veo.","¿Qué hace alguien como tú aquí?","[...]",0);
            dialogChunk("[...]","[...]","[...]",0);
            dialogChunk("Muy bien.","Si también deseas","salvar a los demás...",0);
            dialogChunk("Haré lo que pueda","para ayudarte.","",0);
            dialogChunk("No permitiré que nadie muera.","","",5);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(5),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(13) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("¿Tú eres quién salió de su celda?","Me imagino tendrás tus motivos","",5);
            dialogChunk("Pero si lo que dijo quien","nos ha encerrado es cierto,","entonces es peligroso explorar.",5);
            dialogChunk("Necesitarás alguien que te ayude.","Curar es mi especialidad.","",5);
            dialogChunk("¿Crees que te sirva de algo?","","",5);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(13),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void kingHermesRecruitScene()
    {
        addObject(darkenScreen,640,360);
        showLocation("Sexta celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("¿Qué es eso?","¿Obo?","¿Qué es obo?",0);
            dialogChunk("Hmmm...","No.","Simplemente no entiendo.",0);
            dialogChunk("En fin.","Ya me tiene cansado","esta broma.",0);
            dialogChunk("¿En qué momento","me dejarán salir?","Es la primera vez",0);
            dialogChunk("que me hacen algo así.","¡Inaudito!","",0);
            dialogChunk("Déjame decirte.","Tienes suerte que estoy","de buen humor",6);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(6),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(15) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("¿Qué no me reconoces?","","",6);
            dialogChunk("No.","","",party.getMember1().getId());
            dialogChunk("¡Pero qué imbécil!","","",6);
            dialogChunk("[...]","[...]","[...]",party.getMember1().getId());
            dialogChunk("Vaya, quizá debí permitir que","los campesinos fueran a la escuela.","",6);
            dialogChunk("En fin...","Soy tu rey, Hermes LXIX","",6);
            dialogChunk("¡Libérame en éste instante!","","",6);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(15),1021,287);
            removeObject(unknown);
        }
        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void luisRecruitScene()
    {
        addObject(darkenScreen,640,360);
        showLocation("Séptima celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("¿Haz venido con la intención","de comprar?","Es una lástima.",0);
            dialogChunk("No traigo nada conmigo.","[...]","Ah...",0);
            dialogChunk("¿No has venido a eso?","Entonces no tengo","nada que decirte.",0);
            dialogChunk("[...]","[...]","[...]",0);
            dialogChunk("Eres bastante insistente.","Vamos, te escucho.","[...]",0);
            dialogChunk("Así que sólo fue mala suerte...","Tendrás que compensarme","de algún modo.",0);
            dialogChunk("Puedes empezar","por dejarme salir.","[...]",7);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(7),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(17) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("Sólo un mercader desafortunado.","","",7);
            dialogChunk("Tenía tantos pedidos por entregar","y termino en una celda miserable","en quién sabe dónde.",7);
            dialogChunk("Ya discutiremos después","los detalles del pago.","",7);
            dialogChunk("Sé que eres","quién puede sacarme de aquí.","Dime tu precio.",7);
            dialogChunk("Estoy dispuesto a pagar lo necesario.","¡Sólo sácame de aquí!","",7);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButton = new YesPromptButton(17),1021,287);
            removeObject(unknown);
        }

        removeObject(darkenScreen);
        showLocation("",false);
    }

    public void nagitoRecruitScene()
    {
        addObject(darkenScreen,640,360);
        showLocation("Novena celda",true);

        if(!party.getPartyFlags(0))
        {
            dialogChunk("Está bien.","","",0);
            dialogChunk("Esperaré lo más que pueda.","","",0);
            dialogChunk("Qué suerte tener tiempo,","¿no crees?","",0);
            dialogChunk("Sí.","Me aseguraré que así sea.","",0);
            dialogChunk("pero tú también debes","tener cuidado.","",0);

            quickDialogChunk("Está bien.","","",0);
            quickDialogChunk("Esperaré lo más que pueda.","","",0);
            quickDialogChunk("Qué suerte tener tiempo,","¿no crees?","",0);
            quickDialogChunk("Sí.","Me aseguraré que así sea.","",0);
            quickDialogChunk("pero tú también debes","tener cuidado.","",0);

            quickDialogChunk("Está bien.","","",0);
            quickDialogChunk("Esperaré lo más que pueda.","","",0);
            quickDialogChunk("Qué suerte tener tiempo,","¿no crees?","",0);
            quickDialogChunk("Sí.","Me aseguraré que así sea.","",0);
            quickDialogChunk("pero tú también debes","tener cuidado.","",0);

            quickDialogChunk("Está bien.","","",0);
            quickDialogChunk("Esperaré lo más que pueda.","","",0);
            quickDialogChunk("Qué suerte tener tiempo,","¿no crees?","",0);
            quickDialogChunk("Sí.","Me aseguraré que así sea.","",0);
            quickDialogChunk("pero tú también debes","tener cuidado.","",0);

            quickDialogChunk("Está bien.","","",0);
            quickDialogChunk("Esperaré lo más que pueda.","","",0);
            quickDialogChunk("Qué suerte tener tiempo,","¿no crees?","",0);
            quickDialogChunk("Sí.","Me aseguraré que así sea.","",0);
            quickDialogChunk("pero tú también debes","tener cuidado.","",0);

            dialogChunk("No puedo perder.","","",8);
            dialogChunk("Esta voz...","¿Acaso es mía?","",0);

            addObject(noButton = new NoPromptButton(unknown.getX(),unknown.getY()),264,287);
            addObject(yesButtonSelect = new YesButtonSelect(8),1021,287);
            removeObject(unknown);
        }
        else if(!party.getPartyFlags(19) && !party.getPartyFlags(3))
        {
            dialogChunk("¿Hay alguien ahí?","","",party.getMember1().getId());
            dialogChunk("No lo hagas.","","",8);
            dialogChunk("¿De qué hablas?","","",party.getMember1().getId());
            dialogChunk("No abras la celda.","","",8);
            dialogChunk("¿Por qué?","¿No quieres salir?","",party.getMember1().getId());
            dialogChunk("Aunque...","No creo que sobrevivas solo.","",8);
            dialogChunk("No quiero que mueras.","","",8);
            dialogChunk("[¿Debería dejarlo salir?]","","",party.getMember1().getId());

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

    public void quickDialogChunk(String line1, String line2, String line3, int character)
    {
        addObject(textBox,644,549);
        addObject(portrait = new DialogPortrait(character),380,558);
        addObject(header = new DialogHeader(character),350,460);

        addObject(this.line1 = new DialogLine(line1,1),350,460);
        if(line2=="")
        {
            addObject(icon,973,634);
            quickWait();
        }
        else if(line2!="")
        {
            quickWait();
            addObject(this.line2 = new DialogLine(line2,2),350,460);
            if(line3=="")
            {
                addObject(icon,973,634);
                quickWait();
            }else
            {
                quickWait();
            }
        }
        if(line3!="")
        {
            addObject(this.line3 = new DialogLine(line3,3),350,460);
            addObject(icon,973,634);
            quickWait();
        }

        removeObject(this.line1);

        if(line2!="")
        {
            removeObject(this.line2);
        }
        if(line3!="")
        {
            removeObject(this.line3);
        }
        removeObject(textBox);
        removeObject(portrait);
        removeObject(header);
        removeObject(icon);
    }

    public void dialogChunk(String line1, String line2, String line3, int character)
    {
        addObject(textBox,644,549);
        addObject(portrait = new DialogPortrait(character),380,558);
        addObject(header = new DialogHeader(character),350,460);

        addObject(this.line1 = new DialogLine(line1,1),350,460);
        if(line2=="")
        {
            addObject(icon,973,634);
            waitForInput();
        }
        else if(line2!="")
        {
            waitForInput();
            addObject(this.line2 = new DialogLine(line2,2),350,460);
            if(line3=="")
            {
                addObject(icon,973,634);
                waitForInput();
            }else
            {
                waitForInput();
            }
        }
        if(line3!="")
        {
            addObject(this.line3 = new DialogLine(line3,3),350,460);
            addObject(icon,973,634);
            waitForInput();
        }

        removeObject(this.line1);

        if(line2!="")
        {
            removeObject(this.line2);
        }
        if(line3!="")
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
        prologueMusic.playLoop();
    }

    public static void stopMusic(){
        prologueMusic.stop();
    }
}
