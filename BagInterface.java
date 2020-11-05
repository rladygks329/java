
/**
 *  �������̽���  ����� ������Ʈ�� ������ �����ؾ��մϴ�  
 * 
 */
public interface BagInterface<T> {
	
	// ����� ���� ��Ʈ���� ������ �����ɴϴ�.
	//�� ����� ��Ʈ���� ���� ������ return�մϴ�
	public int getCurrentSize();
	
	//���� ����ִ��� �����ְ� ��������� true �������� false�� �����մϴ�.
	public boolean isEmpty();
	
	/** ���ȿ� new entry�� �ֽ��ϴ�.
	 *  @param newEntry �� ��ü�� ���ο� ��Ʈ���� ���������ֽ��ϴ�
	 *  @return �ִµ� ���������� true ,�ƴϸ� false�� return���ݴϴ�.
	 */
	public boolean add(T newEntry);
	
	/** ��ȿ��� ��Ư���� entry�� �����մϴ� �����ϴٸ� ������;
	 * 
	 * @return Either the removed entry, if the removal was successful, or null
	 */
	public T remove();
	/**
	 * �� �鿡 �־��� �ϳ��� �߻��� �����մϴ� ���� �����ϴٸ鸻����
	 * @param anEntry ������ ��Ʈ��
	 * @return �����ϸ� Ʈ�� ���и� ����
	 */
	public boolean remove(T anEntry);
	
	/**��ȿ� �ִ� ��Ʈ���� ��� �����ض� */
	public void clear();
	
	/**
	 * �� �鿡�� �־��� ��Ʈ���� ��Ÿ�� ������ ���ʽÿ� 
	 * @param entry -����� ��Ʈ��
	 * @return �鿡�� ��Ʈ���� ��Ÿ�� ������ ��ȯ�Ͻʽÿ�
	 */
	public int getFrequencyOF(T entry);
	
	/**
	 * �� �鿡 ��Ʈ���� �����̾��� �����Ͻʽÿ�
	 * @param entry ��ġ�� ��Ʈ��
	 * @return ���� Ʈ�� �ȵ��� ����
	 */
	public boolean contains(T entry);
	/**
	 * ��ȿ� ��� ��Ʈ���� �˻��ϤӤ��ÿ�
	 * @return ��ȿ� ���Ӱ� �Ҵ�� ��� ��Ʈ�� �迭
	 * ���ǻ���: ���� ���� ����ִٸ�  return ��Ʈ���� �������
	 */
	public T[] toArray();
	
	//�� �������̽� ��
	
	

}
