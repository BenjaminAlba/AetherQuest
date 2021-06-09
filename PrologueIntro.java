import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrologueIntro extends World
{
    Image textBox;
    GreenfootSound prologueIntro;
    GreenfootSound openSfx;
    GreenfootSound staticSfx;
    GreenfootSound buttonPress;
    DialogPortrait portrait;
    DialogHeader header;
    DialogLine line1;
    DialogLine line2;
    DialogLine line3;
    DialogIcon icon;
    DialogLocation locationDisplay;
    int flag=1;
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
        if(flag==1)
        {
            setBackground("images/scenes/prologue.jpg");
            prologueIntro.play();

            Greenfoot.delay(540);

            setBackground("images/menu/background.png");

            dialogChunk("Finalmente te despiertas.","Presta atención.","Te he encerrado en una Mazmorra",9);
            dialogChunk("bajo tierra, en un lugar desconocido.","Quizá algún día logres entender mis","razones, pero por ahora espero entiendas",9);
            dialogChunk("que no puedo dejarte salir.","Al menos no ahora.","Esta Mazmorra es un lugar especial,",9);
            dialogChunk("está plagada de monstruos y peligros.","No te aconsejo que te adentres en ella.","Te he dejado suficientes proviciones",9);
            dialogChunk("para que al menos no mueras de hambre.","No sé cuándo podré dejarte salir, pero","si eres sensato te resignarás a esperar.",9);
            dialogChunk("Ahora duerme.","Sólo así puedo ayudarte.","",9);

            showLocation("Tiempo después...",true);

            dialogChunk("He esperado demasiado.","Si sigo así moriré de viejo.","O probablemente muera antes de inanición.",0);
            dialogChunk("Tengo...","Tengo que moverme.","Tengo que salir de aquí.",0);

            openSfx.play();
            showLocation("",false);
            showLocation("Fuera de la celda",true);

            staticSfx.play();
            dialogChunk("¿Se es....a?","¿Siguen t....s ...os?","Veo que alguien ha decidido salir de la celda.",9);
            dialogChunk("Ya que no puedo evitar que exploren la","Mazmorra, permítanme dejar algo tan claro","como pueda.",9);
            dialogChunk("No saldrán todos con vida.","","",9);
            dialogChunk("Tú, quien abandonó su celda...","¿Fuiste tú quien robó las llaves de las demás?","Entonces te habrás dado cuenta.",9);
            dialogChunk("No puedes salvarlos a todos.","Has interferido con mis planes,","y ahora lidiarás con tu castigo.",9);
            dialogChunk("Quienes no elijas morirán.","¿Aún así deseas seguir explorando","la Mazmorra?",9);
            PrologueRoom.playMusic();
            Greenfoot.setWorld(new PrologueRoom("01",640,360));
        }
        flag=0;
    }

    public void waitForInput()
    {
        Greenfoot.delay(20);
        while(!Greenfoot.isKeyDown("enter"));
        buttonPress.play(); 
        Greenfoot.delay(20);
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
}