public class Main {
    public static void main(String[] args) {

        Usuario premium = new Usuario(457, "premium");
        Usuario free = new Usuario(645, "free");
        ProxyDescarga proxy = new ProxyDescarga();

        proxy.descargar(premium, "Breezeblock by Alt-J");
        proxy.descargar(free, "Taro by Alt-J");
    }
}
