package cn.daryu.omsdroid.plus;

import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.IStyledTileSource;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;

/**
 * 
 * 扩展osmdroid的图层源支持google格式的数据源头信息
 * 
 */
public class GoogleMapsTileSource extends OnlineTileSourceBase implements
		IStyledTileSource<Integer> {

	public GoogleMapsTileSource(String aName, string aResourceId,
			int aZoomMinLevel, int aZoomMaxLevel, int aTileSizePixels,
			String aImageFilenameEnding, String[] aBaseUrl) {
		super(aName, aResourceId, aZoomMinLevel, aZoomMaxLevel,
				aTileSizePixels, aImageFilenameEnding, aBaseUrl);
	}

	@Override
	public String getTileURLString(MapTile aTile) {
		return getBaseUrl() + "&x=" + aTile.getX() + "&y=" + aTile.getY()
				+ "&z=" + aTile.getZoomLevel();
	}

	@Override
	public Integer getStyle() {
		return null;
	}

	@Override
	public void setStyle(Integer arg0) {

	}

	@Override
	public void setStyle(String arg0) {

	}
}
