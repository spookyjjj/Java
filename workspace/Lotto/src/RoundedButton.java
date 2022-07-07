import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton { // RoundedButton클래스를 상속받는 RoundedButton 만듦
	public Color bgColor = new Color(255, 247, 242); // 배경색 결정
	public Color fColor = new Color(247, 99, 12); // 글자색 결정

	public RoundedButton() {
		super();
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		decorate();
	}

	public RoundedButton(Action action) {
		super(action);
		decorate();
	}

	public RoundedButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}// decorate()함수

	public void bgSetter(Color c) {
		bgColor = c;
	}

	public void fSetter(Color c) {
		fColor = c;
	}

	@Override
	public void paintComponent(Graphics g) {

		int width = getWidth();
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g; // 2D 그래픽으로 형변환

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 모양이 부드러워짐

		if (!getModel().isEnabled()) { //getModel: 버튼이 나타내는 모델
			graphics.setColor(bgColor.darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(bgColor.brighter());
		} else {
			graphics.setColor(bgColor);
		} // 마우스 올렸을 때 밝아지게 배경색이 밝아지도록

		graphics.fillRoundRect(0, 0, width, height, 10, 10); // 사각형 모양 깎아서 부드럽게

		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		//// fontMetrics, Rectangle를 통해 글자가 그려지는 사각형의 크기를 구함

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		// 그 후 글자가 새겨질 위치를 구한 이후에 글자의 색(getForeground())과 폰트(getFont())를 가져와 drawString를
		// 통해 그림

		graphics.setColor(fColor);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);

		graphics.dispose();
		super.paintComponent(g);
	}
}
