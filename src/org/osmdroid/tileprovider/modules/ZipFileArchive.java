package org.osmdroid.tileprovider.modules;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.ITileSource;

import android.util.Log;

public class ZipFileArchive implements IArchiveFile {

	private final ZipFile mZipFile;

	private ZipFileArchive(final ZipFile pZipFile) {
		mZipFile = pZipFile;
	}

	public static ZipFileArchive getZipFileArchive(final File pFile) throws ZipException, IOException {
		return new ZipFileArchive(new ZipFile(pFile));
	}

	@Override
	public InputStream getInputStream(final ITileSource pTileSource, final MapTile pTile) {
		final String path = pTileSource.getTileRelativeFilenameString(pTile);
		try {
			final ZipEntry entry = mZipFile.getEntry(path);
			if (entry != null) {
				return mZipFile.getInputStream(entry);
			}
		} catch (final IOException e) {
			Log.w("daryu-osmdroid","Error getting zip stream: " + pTile, e);
		}
		return null;
	}

	@Override
	public void close() {
		try {
			mZipFile.close();
		} catch (IOException e) { }
	}

	@Override
	public String toString() {
		return "ZipFileArchive [mZipFile=" + mZipFile.getName() + "]";
	}

}
