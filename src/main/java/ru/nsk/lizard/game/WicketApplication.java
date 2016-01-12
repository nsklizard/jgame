package ru.nsk.lizard.game;



        import org.apache.wicket.markup.html.WebPage;
        import org.apache.wicket.protocol.http.WebApplication;
        import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
        import org.wicketstuff.annotation.scan.AnnotatedMountScanner;
        import ru.nsk.lizard.game.ui.HomePage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage()
    {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init()
    {
        super.init();

        // add your configuration here

        //для mountPath
        new AnnotatedMountScanner().scanPackage("ru.nsk.lizard.game.ui").mount(this);

        //SpringBean
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

    }
}

