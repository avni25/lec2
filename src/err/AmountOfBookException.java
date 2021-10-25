package err;



/**
 * Bu hata sinifi Prof sinifinin en az 3 kitap olmasi kosulunu denetlemek icin olusturulmustur
 * Prof sinifi publishedBook listesi 3 ten az kitap ismi iceriyorsa hata dondurur.
 * */
public class AmountOfBookException extends Exception{
    public AmountOfBookException(String message) {
        super(message);
    }
}
