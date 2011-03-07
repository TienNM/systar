package engine.util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {

    String ends; // �ļ���׺
    String description; // �ļ���������

    public MyFileFilter(String ends, String description) { // ���캯��
        this.ends = ends; // �����ļ���׺
        this.description = description; // �����ļ���������
    }

    @Override
    // ֻ��ʾ������չ�����ļ���Ŀ¼ȫ����ʾ
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String fileName = file.getName();
        if (fileName.toUpperCase().endsWith(this.ends.toUpperCase())) {
            return true;
        }
        return false;
    }

    @Override
    // ���������չ��������������
    public String getDescription() {
        return this.description;
    }

    // ���������չ������������չ��
    public String getEnds() {
        return this.ends;
    }
}
