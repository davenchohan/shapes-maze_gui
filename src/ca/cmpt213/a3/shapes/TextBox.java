package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

/**
 * A class that extends the Rectangle class in order to draw a rectangle
 * and add a message inside it.
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public class TextBox extends Rectangle {
    private String message;

    public TextBox(int locationX, int locationY, int width, int height, String message) {
        super(locationX, locationY, width, height);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int textLocationY = getLocationY() + 1;
        int lastLocationY = getLocationY() + getHeight() - 2;
        int maxTextWidth = getWidth() - 2;
        int textLocationX = getLocationX() + 1 + (maxTextWidth - message.length() + 1) / 2;
        int charPosition = 0;
        // Check if everything fits on first line
        if (message.length() <= maxTextWidth) {
            for (int i = 0; i < message.length(); i++) {
                canvas.setCellText(textLocationX, textLocationY, message.charAt(i));
                textLocationX++;
            }
        } else {
            String totalMessage = message;
            int charLeft = message.length();
            while (textLocationY <= lastLocationY && charLeft > 0 && totalMessage.length() > maxTextWidth) {
                String tempText = totalMessage.substring(0, maxTextWidth);
                int increasedBy = maxTextWidth;
                tempText = tempText.stripTrailing();
                // Break on space if possible
                if (totalMessage.charAt(tempText.length()) != ' ' && totalMessage.charAt(tempText.length() - 1) != ' ') {
                    int lastSpace = tempText.lastIndexOf(' ');
                    if (lastSpace > 0) {
                        tempText = tempText.substring(0, lastSpace);
                        increasedBy = lastSpace + 1;
                    }
                }
                // write the current line
                textLocationX = getLocationX() + 1 + (maxTextWidth - tempText.length() + 1) / 2;
                for (int i = 0; i < tempText.length(); i++) {
                    canvas.setCellText(textLocationX, textLocationY, tempText.charAt(i));
                    textLocationX++;
                }
                charPosition = charPosition + increasedBy;
                charLeft = message.length() - charPosition;
                totalMessage = totalMessage.substring(increasedBy);
                totalMessage = totalMessage.stripLeading();
                textLocationY++;
            }
            // if the rest of the message can be written onto one line
            if (totalMessage.length() < maxTextWidth) {
                textLocationX = getLocationX() + 1 + (maxTextWidth - totalMessage.length() + 1) / 2;
                for (int i = 0; i < totalMessage.length(); i++) {
                    canvas.setCellText(textLocationX, textLocationY, totalMessage.charAt(i));
                    textLocationX++;
                }
            }
        }
    }
}
