package annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;


/**
 * 运行的时候使用下面的方式
 * javac -processor annotation.NameCheckProcessor annotation/BADLY_CODE_NAME.java
 *
 *
 */
@SupportedAnnotationTypes("*")//支持所有注解
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {


    private NameChecker nameChecker;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);

    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        if (!roundEnv.processingOver()){
            for (Element element : roundEnv.getRootElements()) {
                nameChecker.checkNames(element);
            }
        }

        return false;
    }
}
