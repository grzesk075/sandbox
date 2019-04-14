module pl.grzesk075.sandbox {

    exports pl.grzesk075.sandbox; // this package only is available for other modules
    //you can export to only specified modules with keyword 'to'

    requires java.scripting; // this module is used by this module in compile and run times
    requires static java.xml; // required in compile time only
    requires transitive java.datatransfer; // modules using this module require this implicitly

    uses java.util.spi.ToolProvider; // uses this interface or abstract class implementation

    //provides java.nio.file.spi.FileSystemProvider with jdk.internal.jrtfs.JrtFileSystemProvider;
    //provides implementation of this interface
}