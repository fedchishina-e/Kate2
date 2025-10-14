/**
 * This check activates when finds .setSeed() or constructor invocation with :
 * - literal
 * - hardcoded array
 * - .getBytes() method called on literal
 * - .valueOf() with literal as argument
 * - etc. (other predictable expressions)
 */
public class PredictableSeedCheckTest {

    private long seedField = 123456L;
    private static final byte[] arrField = new byte[]{21, 12};
    private String textField = "abcdefghijklmnop";


    void setSeedLiteral() {
        new SecureRandom().setSeed(123456L);    // Flaw

        SecureRandom sr1 = new SecureRandom();
        sr1.setSeed(123456L);                   // Semantic? Flaw
    }

    void setSeedCreator(byte b){

        SecureRandom sr4 = new SecureRandom();
        sr4.setSeed(new byte[]{21, 12});                // Semantic? Flaw
        sr4.setSeed(new byte[]{21, b});                 // OK

        new SecureRandom().setSeed(new byte[]{21, 12}); // Flaw
        new SecureRandom().setSeed(new byte[]{21, b});  // OK
    }

    void setSeedLongIdentifier(Long paramLong) {
        long seed1 = 123456L;
        new SecureRandom().setSeed(seed1);      // Semantic Flaw

        SecureRandom sr2 = new SecureRandom();
        sr2.setSeed(seed1);                     // Semantic? / Semantic Flaw

        new SecureRandom().setSeed(seedField);  // Semantic? Flaw

        SecureRandom sr3 = new SecureRandom();
        sr3.setSeed(seedField);                 // Semantic Flaw

        new SecureRandom().setSeed(paramLong);  //OK

        SecureRandom sr4 = new SecureRandom();
        sr4.setSeed(paramLong);                 // OK
    }

    void setSeedByteArrayIdentifier(byte[] paramByte) {
        byte[] arr1 = new byte[]{21, 12};
        new SecureRandom().setSeed(arr1);       // Semantic Flaw

        SecureRandom sr5 = new SecureRandom();
        sr5.setSeed(arr1);                      // Semantic? / Semantic Flaw

        new SecureRandom().setSeed(arrField);   // Semantic Flaw

        SecureRandom sr6 = new SecureRandom();
        sr6.setSeed(arrField);                  // Semantic? / Semantic Flaw

        new SecureRandom().setSeed(paramByte);  //OK

        SecureRandom sr7 = new SecureRandom();
        sr7.setSeed(paramByte);                 // OK
    }

    void setSeedMethodCall(String paramText) {
        new SecureRandom().setSeed("abcdefghijklmnop".getBytes("us-ascii"));    // Flaw
        new SecureRandom().setSeed("abcdefghijklmnop".getBytes());              // Flaw

        SecureRandom sr1 = new SecureRandom();
        sr1.setSeed("abcdefghijklmnop".getBytes("us-ascii"));   // Semantic? Flaw
        sr1.setSeed("abcdefghijklmnop".getBytes());             // Semantic? Flaw

        String text1 = "abcdefghijklmnop";
        new SecureRandom().setSeed(text1.getBytes("us-ascii")); // Semantic Flaw
        new SecureRandom().setSeed(text1.getBytes());           // Semantic Flaw

        SecureRandom sr2 = new SecureRandom();
        sr2.setSeed(text1.getBytes("us-ascii"));    // Semantic? / Semantic Flaw
        sr2.setSeed(text1.getBytes());              // Semantic? / Semantic Flaw


        new SecureRandom().setSeed(textField.getBytes("us-ascii")); // Semantic Flaw

        SecureRandom sr3 = new SecureRandom();
        sr3.setSeed(textField.getBytes("us-ascii"));                // Semantic? / Semantic Flaw

        new SecureRandom().setSeed(paramText.getBytes("us-ascii")); // OK

        SecureRandom sr8 = new SecureRandom();
        sr8.setSeed(paramText.getBytes("us-ascii"));                // OK
    }


    void constructorMethodCall(byte[] param, String paramText){
        new SecureRandom("abcdefghijklmnop".getBytes("us-ascii"));  // Flaw

        String text1 = "abcdefghijklmnop";
        new SecureRandom(text1.getBytes("us-ascii"));               // Semantic Flaw

        new SecureRandom(textField.getBytes("us-ascii"));           // Semantic Flaw

        new SecureRandom(paramText.getBytes("us-ascii"));           // OK
    }

    void constructorCreator(byte[] param, String paramText){
        new SecureRandom(new byte[]{21,12});    // Flaw

        new SecureRandom();                     // OK
        new SecureRandom(param);                // OK
    }

    void constructorIdentifier(byte[] param, String paramText){
        byte[] arr1 = new byte[]{21,12};
        new SecureRandom(arr1);         // Semantic Flaw
        new SecureRandom(arrField);     // Semantic Flaw

        new SecureRandom(param);        // OK
        new SecureRandom();             // OK
    }
}