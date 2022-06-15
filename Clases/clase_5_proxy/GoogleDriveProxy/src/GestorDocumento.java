import java.util.ArrayList;
import java.util.List;

public class GestorDocumento extends GoogleDrive {

    private List<Documento> documentos = new ArrayList<>();

    public GestorDocumento(){

    }

    @Override
    public String entregarDoc(String id, String url, String nombre, String email) {
        String resp = "";
        for (Documento doc : documentos) {
            if (doc.getId() == id & doc.getUrl() == url){
                resp = doc.getContenido();
            }

        }
        return resp;
    }

    public void addDoc(Documento documento){
        documentos.add(documento);
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}
