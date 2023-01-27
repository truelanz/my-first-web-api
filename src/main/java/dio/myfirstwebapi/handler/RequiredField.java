package dio.myfirstwebapi.handler;

public class RequiredField extends BusinessException {

    public RequiredField(String requiredField) {
        super("Campo obrigatório", requiredField);
    }


    
}
