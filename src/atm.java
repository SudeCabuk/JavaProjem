import java.util.Scanner;

public class atm {
   private final String correctUsername = "sude";
   private final String correctPassword = "1234";
   private int bakiye = 1000;

   public void start() {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Atm'ye hoşgeldiniz!");
       boolean loggedIn = false;

       for (int attempts = 3; attempts > 0; attempts--) {
           System.out.print("Kullanıcı adınızı girin: ");
           String username = scanner.nextLine();

           System.out.print("Şifrenizi girin: ");
           String password = scanner.nextLine();

           if (username.equals(correctUsername) && password.equals(correctPassword)) {
               System.out.println("Giriş başarılı!");
               loggedIn = true;
               break;
           } else {
               System.out.println("Hatalı kullanıcı adı veya şifre. Kalan deneme hakkınız: " + (attempts - 1));
           }
       }
       if (!loggedIn) {
           System.out.println("Hesabınız bloke edildi. Lütfen banka ile iletişime geçin.");
           scanner.close();
           return;
       }
       while (true) {
           System.out.println("\nLütfen yapmak istediğiniz işlemi seçin:");
           System.out.println("1. Bakiye Görüntüleme");
           System.out.println("2. Para Yatırma");
           System.out.println("3. Para Çekme");
           System.out.println("4. Çıkış Yap");

           System.out.print("Seçiminiz: ");
           int secim = scanner.nextInt();

           switch (secim) {
               case 1:
                   System.out.println("Mevcut bakiyeniz: " + bakiye + " TL");
                   break;

               case 2:
                   System.out.print("Yatırmak istediğiniz tutarı girin: ");
                   int yatirilanTutar = scanner.nextInt();
                   if (yatirilanTutar > 0) {
                       bakiye += yatirilanTutar;
                       System.out.println(yatirilanTutar + " TL hesabınıza eklendi. Yeni bakiyeniz: " + bakiye + " TL");
                   } else {
                       System.out.println("Geçersiz bir tutar girdiniz. Lütfen pozitif bir sayı girin.");
                   }
                   break;

               case 3:
                   System.out.print("Çekmek istediğiniz tutarı girin: ");
                   int cekilenTutar = scanner.nextInt();
                   if (cekilenTutar > 0 && cekilenTutar <= bakiye) {
                       bakiye -= cekilenTutar;
                       System.out.println(cekilenTutar + " TL hesabınızdan çekildi. Yeni bakiyeniz: " + bakiye + " TL");
                   } else if (cekilenTutar > bakiye) {
                       System.out.println("Yetersiz bakiye. Mevcut bakiyeniz: " + bakiye + " TL");
                   } else {
                       System.out.println("Geçersiz bir tutar girdiniz. Lütfen pozitif bir sayı girin.");
                   }
                   break;

               case 4:
                   System.out.println("Çıkış yapılıyor. Bizi tercih ettiğiniz için teşekkür ederiz!");
                   scanner.close();
                   return;

               default:
                   System.out.println("Geçersiz bir seçim yaptınız. Lütfen 1-4 arasında bir değer girin.");
           }
       }


   }
    }

