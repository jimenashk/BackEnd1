public class Main {
    public static void main(String[] args) {

        //crear documentos con lista d usuarios autorizados

        UsuarioAutorizado usuario1 = new UsuarioAutorizado("Maria", "Maria@gmail.com");
        UsuarioAutorizado usuario2 = new UsuarioAutorizado("Lucas", "Lucas@gmail.com");
        Documento documento1 = new Documento("doc1.com", "1", "Soy contenido nro 1");
        Documento documento2 = new Documento("doc2.com", "2", "Soy contenido nro 2");

        documento1.addUsuario(usuario1);
        documento1.addUsuario(usuario2);
        documento2.addUsuario(usuario1);

        //creacion de proxy y gestor
        GestorDocumento gestor = new GestorDocumento();
        ProxyGestor proxy = new ProxyGestor(gestor);
        proxy.addDocumento(documento1);
        gestor.addDoc(documento2);

        //acceder al contenido a traves del proxy
        System.out.println("");
        System.out.println("Pedido del usuario Lucas: ");
        System.out.println(proxy.entregarDoc("1", "doc1.com", "Lucas", "Lucas@gmail.com"));
    }
}
