import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueIntro extends World
{
    private Image textBox;
    private GreenfootSound prologueIntro;
    private GreenfootSound openSfx;
    private GreenfootSound staticSfx;
    private GreenfootSound buttonPress;
    private DialogPortrait portrait;
    private DialogHeader header;
    private DialogLine line1;
    private DialogLine line2;
    private DialogLine line3;
    private DialogIcon icon;
    private DialogLocation locationDisplay;
    private CharacterNameProvider unknownName = new UnknownNameProvider();
    private CharacterNameProvider emptyName = new EmptyNameProvider();
    public PrologueIntro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        textBox = new Image("images/dialog/dialog_box.png");
        icon = new DialogIcon();
        prologueIntro = new GreenfootSound("sounds/chapterStart.mp3");
        buttonPress = new GreenfootSound("sounds/button_click.mp3");
        openSfx = new GreenfootSound("sounds/open_sfx.mp3");
        staticSfx = new GreenfootSound("sounds/static_sfx.mp3");
    }

    public void act()
    {
        prologueIntroScene();
    }

    public void prologueIntroScene()
    {
        setBackground("images/scenes/prologue.jpg");
        prologueIntro.play();

        Greenfoot.delay(540);

        setBackground("images/menu/background.png");

        dialogChunk("Finalmente te despiertas.","Presta atención.","Te he encerrado en una Mazmorra",emptyName);
        dialogChunk("bajo tierra, en un lugar desconocido.","Quizá algún día logres entender mis","razones, pero por ahora espero entiendas",emptyName);
        dialogChunk("que no puedo dejarte salir.","Al menos no ahora.","Esta Mazmorra es un lugar especial,",emptyName);
        dialogChunk("está plagada de monstruos y peligros.","No te aconsejo que te adentres en ella.","Te he dejado suficientes proviciones",emptyName);
        dialogChunk("para que al menos no mueras de hambre.","No sé cuándo podré dejarte salir, pero","si eres sensato te resignarás a esperar.",emptyName);
        dialogChunk("Ahora duerme.","Sólo así puedo ayudarte.","",emptyName);

        showLocation("Tiempo después...",true);

        dialogChunk("He esperado demasiado.","Si sigo así moriré de viejo.","O probablemente muera antes de inanición.",unknownName);
        dialogChunk("Tengo...","Tengo que moverme.","Tengo que salir de aquí.",unknownName);

        openSfx.play();
        showLocation("",false);
        showLocation("Fuera de la celda",true);

        staticSfx.play();
        dialogChunk("¿Se es....a?","¿Siguen t....s ...os?","Veo que alguien ha decidido salir de la celda.",emptyName);
        dialogChunk("Ya que no puedo evitar que exploren la","Mazmorra, permítanme dejar algo tan claro","como pueda.",emptyName);
        dialogChunk("No saldrán todos con vida.","","",emptyName);
        dialogChunk("Tú, quien abandonó su celda...","¿Fuiste tú quien robó las llaves de las demás?","Entonces te habrás dado cuenta.",emptyName);
        dialogChunk("No puedes salvarlos a todos.","Has interferido con mis planes,","y ahora lidiarás con tu castigo.",emptyName);
        dialogChunk("Quienes no elijas morirán.","¿Aún así deseas seguir explorando","la Mazmorra?",emptyName);
        PrologueRoom.playMusic();
        Greenfoot.setWorld(new PrologueRoom("01",640,360));
    }

    public void waitForInput()
    {
        Greenfoot.delay(20);
        while(!Greenfoot.isKeyDown("enter"));
        buttonPress.play(); 
        Greenfoot.delay(20);
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
}