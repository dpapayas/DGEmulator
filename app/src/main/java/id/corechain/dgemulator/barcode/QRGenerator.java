package id.corechain.dgemulator.barcode;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

import id.corechain.dgemulator.R;

import static android.graphics.Color.WHITE;

/**
 * Created by dpapayas on 7/20/17.
 */

public class QRGenerator {

    public void GenerateQR(Activity activity, String text, ImageView ivQr) {
        try {
            int width = 2000;
            int height = 2000;
            int smallestDimension = width < height ? width : height;

            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            QRGenerator qrGenerator = new QRGenerator();
            qrGenerator.CreateQRCode(activity, text, charset, hintMap, smallestDimension, smallestDimension, ivQr);

        } catch (Exception ex) {
            Log.e("QrGenerate", ex.getMessage());
        }

    }

    public void CreateQRCode(Activity activity, String qrCodeData, String charset, Map hintMap, int qrCodeheight, int qrCodewidth, ImageView imageView) {

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);

            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];
            for (int y = 0; y < height; y++) {
                int offset = y * width;
                for (int x = 0; x < width; x++) {
                    pixels[offset + x] = matrix.get(x, y) ?
                            ResourcesCompat.getColor(activity.getResources(), R.color.black, null) : WHITE;
                }
            }

            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

            Bitmap overlay = BitmapFactory.decodeResource(activity.getResources(), R.drawable.logo);

            imageView.setImageBitmap(mergeBitmaps(overlay, bitmap));
//            imageView.setImageBitmap(bitmap);

        } catch (Exception er) {
            Log.e("QrGenerate", er.getMessage());
        }
    }

    public Bitmap mergeBitmaps(Bitmap overlay, Bitmap bitmap) {

        int height = bitmap.getHeight();
        int width = bitmap.getWidth();

        Bitmap combined = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Canvas canvas = new Canvas(combined);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        canvas.drawBitmap(bitmap, new Matrix(), null);

        int centreX = (canvasWidth - overlay.getWidth()) / 2;
        int centreY = (canvasHeight - overlay.getHeight()) / 2;
        canvas.drawBitmap(overlay, centreX, centreY, null);

        return combined;
    }

    public void QRScanner(String text, ImageView imageView) {
        int width = 1000;
        int height = 1000;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 2 / 4;

        //Encode with a QR Code image
        QREncoder qrCodeEncoder = new QREncoder(text,
                null,
                Contents.Type.TEXT,
                BarcodeFormat.QR_CODE.toString(),
                smallerDimension);
        try {
            Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
            imageView.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

}
