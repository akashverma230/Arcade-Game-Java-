package sprites;

import utils.GameConstants;

public class kenPlayer extends Sprites implements GameConstants{
public kenPlayer() throws Exception {
	// TODO Auto-generated constructor stub
	super(KEN_IMAGE);
	x=BOARD_WIDTH-200;
}
@Override
public void defaultAction() {
	int w = 65;
	int h = 90;
	//-2028px -868px;
	defaultMove[0] =  fullImage.getSubimage(2028, 864, w, h);
	defaultMove[1] =  fullImage.getSubimage(1963, 864, w, h);
	defaultMove[2] =  fullImage.getSubimage(1887, 864, w, h);
	defaultMove[3] =  fullImage.getSubimage(1815, 864, w, h);
	defaultMove[4] =  fullImage.getSubimage(1753, 864, w, h);
	defaultMove[5] =  fullImage.getSubimage(1685, 864, w, h);
}
@Override
protected void kickAction() {
	// TODO Auto-generated method stub
	int w = 70;
	kick[0] =  fullImage.getSubimage(1732, 1666, w, 100);
	kick[1] =  fullImage.getSubimage(1663, 1669, w, 100);
	kick[2] =  fullImage.getSubimage(1594, 1666, w, 100);
	kick[3] =  fullImage.getSubimage(1466, 1662, w, 100);
	kick[4] =  fullImage.getSubimage(1399, 1668, w-10, 100);
	kick[5] =  fullImage.getSubimage(1732, 1666, w, 100);
}
@Override
protected void hit() {
	// TODO Auto-generated method stub
	int h = 90;
	int w = 65;
	// TODO Auto-generated method stub
	hitMove[0] = fullImage.getSubimage(1360,3277,w,h);
	hitMove[1] = fullImage.getSubimage(1436,3277,w,h);
	hitMove[2] = fullImage.getSubimage(1539,3277,w,h);
	hitMove[3] = fullImage.getSubimage(1628,3277,w,h);
	hitMove[4] = fullImage.getSubimage(1704,3277,w,h);
	hitMove[5] = fullImage.getSubimage(1360,3277,w,h);

}

}
