import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

public class TextComponent extends ViewComponent
{
    //Uses TextFlow instead of Text to enable formatting.
    //Unsure about this though because it requires much more
    //object recreation whenever changing text content or font.
    private TextFlow thisObject;
    private Font font;
    private String text;
    
    public TextComponent()
    {
        thisObject = new TextFlow();
    }
    @Override
    protected void setHiddenHelper(boolean isHidden)
    {
        thisObject.setVisible(!isHidden);
    }
    @Override
    protected void updateXYHelper(int[] xyCords)
    {
        thisObject.setX(xyCords[0]);
        thisObject.setY(xyCords[2]);
        thisObject.setPrefWidth(xyCords[1]-xyCords[0]);
        thisObject.setPrefHeight(xyCords[3]-xyCords[2]);
    }

    public void setText(String text)
    {
        this.text = text;
        Text newText = new Text(text);
        TextFlow newObject = new TextFlow(text);
        thisObject = newObject;
    }
    public void setFont(Font font)
    {
        this.font = font;
        Text newText = new Text(text);
        newText.setFont(font);
        TextFlow newObject = new TextFlow(newText);
        thisObject = newObject;
    }
    public String getText()
    {
        return text;
    }
    //probably wont need
    public Font getFont()
    {
        return font;
    }
}
